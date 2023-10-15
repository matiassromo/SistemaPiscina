import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Ventana {
    private JScrollPane scroll;
    private JPanel tabEvent;
    private JPanel panel1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JTable tbProductos;
    private JSpinner spiCantidadProductos;
    private JButton btnSolicitar;
    private JButton btnAtenderPedido;
    private JList list1;
    private JComboBox cboReabastecer;
    private JButton btnReabastecer;
    private JButton btnIngresar;
    private JTextField txtIngresarN;
    private JTextField txtIngresarD;
    private JTextField txtIngresarP;
    private JTextField txtIngresarC;
    private JComboBox cboTipo;
    private JTextField txtNombre;
    private JSpinner spiAdultos;
    private JSpinner spiNinios;
    private JSpinner spiAcompaniantes;
    private JSpinner spiTerceraEdad;
    private JTextArea txtArea;
    private JComboBox cboMembresia;
    private JTabbedPane  tabbedPane1;
    private JPanel Principal;
    private JButton btnRegistrar;
    private JButton btnOrdenar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JSpinner spiCantidadReab;
    private JTextField textContrasena;
    private JTextField textCedula;
    private JComboBox cboGenero;
    private JButton buttonAsignarCasillero;
    private JTextField txtFecha;
    private JTextField txtCedulaCliente;
    private JButton btnAgregarEvento;
    private JTextArea txtAreaEditarEventos;
    private JButton btnEditarEvento;
    private JButton btnEliminarEvento;
    private JButton btnOrdenarEvento;
    private JComboBox cboTipoEvento;
    private JSpinner spCantidadInvitados;
    private JTextArea txtAreaRegistrarEventos;
    private JTable tbTuberias;
    private JButton btnAtender;
    private JButton btnAnomalia;
    private JTextField txtAnomalia;
    private JComboBox cboTuberias;
    private JTextField txtNombreClientes;
    private JTextField textCedulaCasilleros;
    private JButton buttonBuscar;
    private JButton buttonEliminarCasillero;
    private JButton buttonVisualizarCasillerosOcupados;
    private JTextArea textArbolCasilleros;
    private JButton buttonVisualizarCasillerosDisponibles;

    ListaClientes clientes = new ListaClientes();
    ListaEventos eventos = new ListaEventos();
    ArbolGenero arbol = new ArbolGenero();

    private DefaultTableModel model = new DefaultTableModel();
    private DefaultTableModel dtmT=new DefaultTableModel();
    private DefaultListModel dlm=new DefaultListModel();
    BarCliente BC=new BarCliente();
    SistemaTuberias ST=new SistemaTuberias();
    ArrayList<Producto> arreglo=new ArrayList<>();
    ArrayList<Tuberia> arregloTuberia=new ArrayList<>();


    public Ventana() {
        buttonAsignarCasillero.setVisible(false);
        buttonEliminarCasillero.setVisible(false);
        buttonVisualizarCasillerosOcupados.setVisible(false);
        buttonVisualizarCasillerosDisponibles.setVisible(false);
        arbol.inicializarCasilleros();

        for(Tuberia p:ST.getListadoTuberias()){
            cboTuberias.addItem(p.getNombre());
        }

        SpinnerNumberModel spinnerModel = (SpinnerNumberModel) spiAdultos.getModel();
        SpinnerNumberModel spinnerCantidadModel = (SpinnerNumberModel) spiCantidadProductos.getModel();
        SpinnerNumberModel spinnerCantidadReab = (SpinnerNumberModel) spiCantidadReab.getModel();
        spinnerModel.setMinimum(0);
        spinnerModel.setMaximum(Integer.MAX_VALUE);
        spinnerCantidadModel.setMinimum(0);
        spinnerCantidadModel.setMaximum(Integer.MAX_VALUE);
        spinnerCantidadReab.setMinimum(0);
        spinnerCantidadReab.setMaximum(Integer.MAX_VALUE);

        model.addColumn("Nombre Producto");
        model.addColumn("Descripcion");
        model.addColumn("Precio");
        model.addColumn("Tipo");
        model.addColumn("Cantidad");
        tbProductos.setModel(model);
        arreglo=BC.getListadoProductoNombre();
        actualizarLista();

        dtmT.addColumn("Nombre");
        dtmT.addColumn("Estado");
        dtmT.addColumn("Comentario");
        dtmT.addColumn("Abierto/Cerrado");
        tbTuberias.setModel(dtmT);
        arregloTuberia=ST.getListadoTuberias();
        actualizarListaTuberias();

        spiCantidadReab.setEditor(new JSpinner.DefaultEditor(spiCantidadReab));
        spiCantidadReab.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (int) spiCantidadReab.getValue();
                if (value < 0) {
                    spiCantidadReab.setValue(0);
                }
            }
        });

        spiCantidadProductos.setEditor(new JSpinner.DefaultEditor(spiCantidadProductos));

        spiCantidadProductos.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (int) spiCantidadProductos.getValue();
                if (value < 0) {
                    spiCantidadProductos.setValue(0);
                }
            }
        });

        spiAdultos.setEditor(new JSpinner.DefaultEditor(spiAdultos));
        spiNinios.setEditor(new JSpinner.DefaultEditor(spiNinios));
        spiAcompaniantes.setEditor(new JSpinner.DefaultEditor(spiAcompaniantes));
        spiTerceraEdad.setEditor(new JSpinner.DefaultEditor(spiTerceraEdad));

        spiAdultos.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (int) spiAdultos.getValue();
                if (value < 0){
                    spiAdultos.setValue(0);
                }
            }
        });

        spiNinios.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (int) spiNinios.getValue();
                if (value < 0){
                    spiNinios.setValue(0);
                }
            }
        });

        spiAcompaniantes.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (int) spiAcompaniantes.getValue();
                if (value < 0){
                    spiAcompaniantes.setValue(0);
                }
            }
        });

        spiTerceraEdad.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (int) spiTerceraEdad.getValue();
                if (value < 0){
                    spiTerceraEdad.setValue(0);
                }
            }
        });

        spCantidadInvitados.setEditor(new JSpinner.DefaultEditor(spCantidadInvitados));

        spCantidadInvitados.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (int) spCantidadInvitados.getValue();
                if (value < 0){
                    spCantidadInvitados.setValue(0);
                }
            }
        });

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = txtNombre.getText();
                String cedula=textCedula.getText();
                String contrasena=textContrasena.getText();
                String genero = cboGenero.getSelectedItem().toString();
                if(cedula.length()!=10){
                    JOptionPane.showMessageDialog(null, "Revise si se ingreso una cedula correcta");//Validacion cedula
                }
                else if(validadorDeCedula(cedula)){
                if (nombre.trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa el nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if(!nombre.matches("[a-zA-Z\\s]+")){
                    JOptionPane.showMessageDialog(null, "El nombre debe contener solo letras", "Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int adultos = (int) spiAdultos.getValue();
                int ninios = (int) spiNinios.getValue();
                int acompaniantes = (int) spiAcompaniantes.getValue();
                int terceraEdad = (int) spiTerceraEdad.getValue();

                if(adultos == 0 && ninios ==0 && acompaniantes == 0 && terceraEdad == 0){
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa las cantidades", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Random cdRandom = new Random();
                int codigo = cdRandom.nextInt(1000);
                String membresia = cboMembresia.getSelectedItem().toString();

                DatosCliente cliente = new DatosCliente(nombre, adultos, ninios, terceraEdad, acompaniantes, membresia, codigo,cedula,contrasena, genero);

                clientes.agregarCliente(cliente);

                String infoCliente = clientes.reporteCliente();
                txtArea.setText(infoCliente);

                JOptionPane.showMessageDialog(null, "Se ha registrado el cliente exitosamente");

                txtNombre.setText("");
                spiAdultos.setValue(0);
                spiNinios.setValue(0);
                spiAcompaniantes.setValue(0);
                spiTerceraEdad.setValue(0);
                textCedula.setText("");
                textContrasena.setText("");
            }}
        });

        btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(clientes.getListaClientes().isEmpty()){
                    JOptionPane.showMessageDialog(null, "No hay clientes registrados", "Error", JOptionPane.ERROR_MESSAGE);
                }else if (clientes.getListaClientes().size()==1) {
                    JOptionPane.showMessageDialog(null, "Deben haber al menos 2 datos para ordenar","Error",JOptionPane.ERROR_MESSAGE);
                }else {
                    txtArea.setText("");
                    Collections.sort(clientes.getListaClientes());
                    for (DatosCliente d : clientes.getListaClientes()) {
                        String infoCliente = clientes.reporteCliente();
                        txtArea.setText(infoCliente);
                    }
                    JOptionPane.showMessageDialog(null,"Clientes ordenados correctamente");
                }

            }

        });
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clientes.tamanio()>0) {
                    String nombre = JOptionPane.showInputDialog("Coloque el nombre del cliente a editar: ");
                    boolean clienteEncontrado = false;
                    for(DatosCliente c: clientes.getListaClientes())
                    {
                        if (c.getNombre().equals(nombre)){
                            clienteEncontrado = true;
                            if (nombre != null) {
                                String nuevoNombre = JOptionPane.showInputDialog("Coloque el nuevo nombre del cliente: ");
                                if (nuevoNombre != null) {
                                    String membresiaStr = JOptionPane.showInputDialog("Coloque el nuevo estado de la membresia (Si/No): ");
                                    String cedula=JOptionPane.showInputDialog("Ingrese la nueva cedula: ");
                                    if(cedula.length()!=10){
                                        JOptionPane.showMessageDialog(null, "Revise si se ingreso una cedula correcta");//Validacion cedula
                                    } else if (validadorDeCedula(cedula)){
                                    String contrasena = JOptionPane.showInputDialog("Ingrese la nueva contrasena: ");
                                    if (membresiaStr != null) {
                                        String membresia = (membresiaStr);
                                        clientes.modificarDatos(nombre, new DatosCliente(nuevoNombre, membresia,cedula,contrasena));
                                        System.out.println(clientes.getListaClientes());
                                        String infoCliente = clientes.reporteCliente();
                                        txtArea.setText(infoCliente);
                                        JOptionPane.showMessageDialog(null, "Se modificó los datos correctamente");
                                    }   else JOptionPane.showMessageDialog(null, "Se canceló la operación exitosamente");
                                }}   else JOptionPane.showMessageDialog(null, "Se canceló la operación exitosamente");
                            }
                            else JOptionPane.showMessageDialog(null, "Se canceló la operación exitosamente");
                            break;
                        }
                    }
                    if(!clienteEncontrado){
                        JOptionPane.showMessageDialog(null, "No se encontro el cliente", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else JOptionPane.showMessageDialog(null,"No hay clientes registrados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clientes.getListaClientes().isEmpty()){
                    JOptionPane.showMessageDialog(null, "No hay clientes registrados", "Error", JOptionPane.ERROR_MESSAGE);}
                else{
                String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente a eliminar: ");
                clientes.eliminarCliente(nombreCliente);
                String infoCliente = clientes.reporteCliente();
                txtArea.setText(infoCliente);
            }}
        });



        tbProductos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                spiCantidadProductos.setValue(0);
            }
        });

        btnSolicitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contrasena="";
                String cedula=JOptionPane.showInputDialog("Ingrese la cedula: ");
                if(cedula.length()!=10){
                    JOptionPane.showMessageDialog(null, "Revise si se ingreso una cedula correcta");//Validacion cedula
                }
                else if (validadorDeCedula(cedula)){
                if (clientes.buscarCliente(cedula)){
                    contrasena=JOptionPane.showInputDialog("Ingrese la contrasena: ");}
                if (clientes.buscarContrasena(contrasena)){
                    int prioridad = 0;
                    int cantidad = (int) spiCantidadProductos.getValue();

                    if (tbProductos.getSelectedRow() != -1) {
                        String nombrePedido = (String) model.getValueAt(tbProductos.getSelectedRow(), 0);
                        double precio = Double.parseDouble(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
                        boolean r = false;

                        if (cantidad == 1) {
                            if (BC.validarStock(cantidad, nombrePedido) == r) {
                                prioridad = 3;
                                BC.buscarPedido(nombrePedido, prioridad, cantidad);
                                JOptionPane.showMessageDialog(null, "El pedido de " + tbProductos.getValueAt(tbProductos.getSelectedRow(), 0) +
                                        " se ha realizado correctamente con una prioridad de: " + prioridad+"\nEl cliente deberá pagar: " + cantidad*precio+" dólares");
                            }
                        } else if (cantidad > 1 && cantidad < 10) {
                            if (BC.validarStock(cantidad, nombrePedido) == r) {
                                prioridad = 2;
                                BC.buscarPedido(nombrePedido, prioridad, cantidad);
                                JOptionPane.showMessageDialog(null, "El pedido de " + tbProductos.getValueAt(tbProductos.getSelectedRow(), 0) +
                                        " se ha realizado correctamente con una prioridad de: " + prioridad+"\nEl cliente deberá pagar: " + cantidad*precio+" dólares");
                            }
                        } else if (cantidad >= 10) {
                            if (BC.validarStock(cantidad, nombrePedido) == r) {
                                prioridad = 1;
                                BC.buscarPedido(nombrePedido, prioridad, cantidad);
                                JOptionPane.showMessageDialog(null, "El pedido de " + tbProductos.getValueAt(tbProductos.getSelectedRow(), 0) +
                                        " se ha realizado correctamente con una prioridad de: " + prioridad+"\nEl cliente deberá pagar: " + cantidad*precio+" dólares");
                            }
                        } else if (cantidad == 0) {
                            JOptionPane.showMessageDialog(null, "Seleccione una cantidad válida", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        llenarTabla();
                        limpiarLista();
                        actualizarLista();
                    } else {
                        JOptionPane.showMessageDialog(null, "No ha seleccionado ningún producto", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }}}
            });

        btnReabastecer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String producto= cboReabastecer.getSelectedItem().toString();
                int cantidadReabastecer=(int)spiCantidadReab.getValue();
                if (cantidadReabastecer == 0) {
                    JOptionPane.showMessageDialog(null, "Seleccione la cantidad de productos a reabastecer", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                BC.reabastecer(producto,cantidadReabastecer);
                limpiarLista();
                actualizarLista();
            }
        });

        btnAtenderPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list1.getModel().getSize() == 0) {
                    JOptionPane.showMessageDialog(null, "No hay pedidos para atender", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    BC.desencolar();
                    llenarTabla();
                    JOptionPane.showMessageDialog(null,"Pedido atendido con exito");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre=txtIngresarN.getText();
                String descripcion = txtIngresarD.getText();
                String precioStr = txtIngresarP.getText();
                String cantidadStr = txtIngresarC.getText();

                if (nombre.trim().isEmpty() || descripcion.trim().isEmpty() || precioStr.trim().isEmpty() || cantidadStr.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double precio = 0;
                try {
                    precio = Double.parseDouble(precioStr);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El precio debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;

                }

                int cantidad;
                try {
                    cantidad = Integer.parseInt(cantidadStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "La cantidad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if(BC.validar(nombre)) {
                    if(precio < 0 || cantidad < 0) {
                        JOptionPane.showMessageDialog(null, "Los valores deben ser positivo", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Producto p = new Producto(txtIngresarN.getText(), txtIngresarD.getText(), Double.parseDouble(txtIngresarP.getText()), Integer.parseInt(txtIngresarC.getText()), cboTipo.getSelectedItem().toString());
                    BC.agregarProducto(p);
                    arreglo.add(p);
                    limpiarLista();
                    actualizarLista();
                    cboReabastecer.addItem(txtIngresarN.getText());
                    JOptionPane.showMessageDialog(null, "Producto agregado exitosamente");
                }
                else
                    JOptionPane.showMessageDialog(null, "El producto ya esta ingresado");

            }
        });

        btnAgregarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoEvento = cboTipoEvento.getSelectedItem().toString();
                String nombreCliente = txtNombreClientes.getText();
                String cedula = txtCedulaCliente.getText();
                if(cedula.length()!=10){
                    JOptionPane.showMessageDialog(null, "Revise si se ingreso una cedula correcta");//Validacion cedula
                }
                else if (validadorDeCedula(cedula)) {
                    if (clientes.buscarCliente(cedula)){
                    int cantidadInvitados = (int) spCantidadInvitados.getValue();
                    String fecha = txtFecha.getText();
                    int precioEvento = 0;


                    Evento evento = new Evento();
                    if (tipoEvento.equals("Cumpleaños")) {
                        precioEvento = 50;
                    } else if (tipoEvento.equals("Festejos")) {
                        precioEvento = 20;
                    } else if (tipoEvento.equals("Fin de año")) {
                        precioEvento = 40;
                    }

                    evento.setTipoEvento(tipoEvento);
                    evento.setCantidadInvitados(cantidadInvitados);
                    evento.setFechaEvento(fecha);
                    evento.setPrecioEvento(precioEvento);
                    evento.setCedula(cedula);
                    evento.setNombreCliente(nombreCliente);

                    eventos.agregarEvento(evento);

                    String infoEvento = eventos.generarReporte();
                    txtAreaRegistrarEventos.setText(infoEvento);
                    txtAreaEditarEventos.setText(infoEvento);
                }}
            }
        });
        btnEditarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cedula = JOptionPane.showInputDialog(null,"Ingrese la cedula");
                if(cedula.length()!=10){
                    JOptionPane.showMessageDialog(null, "Revise si se ingreso una cedula correcta");//Validacion cedula
                }
                else if (validadorDeCedula(cedula)) {
                    if (clientes.buscarCliente(cedula)){
                    String nombreCliente = txtNombreClientes.getText();
                    String tipoEvento = JOptionPane.showInputDialog(null, "Ingrese el tipo de evento: ");
                    int cantidadInvitados = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la nueva cantidad de invitados: "));
                    String fecha = JOptionPane.showInputDialog("Ingrese la nueva fecha por favor (DD/MM/AAAA)");

                    Evento evento = new Evento(tipoEvento, cantidadInvitados, fecha, cedula, nombreCliente);

                    eventos.actualizarDatos(cedula, evento);

                    String infoEvento = eventos.generarReporte();
                    txtAreaRegistrarEventos.setText(infoEvento);
                    txtAreaEditarEventos.setText(infoEvento);
                }}
            }
        });
        btnEliminarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = JOptionPane.showInputDialog(null,"Ingrese la cedula");
                if(cedula.length()!=10){
                    JOptionPane.showMessageDialog(null, "Revise si se ingreso una cedula correcta");//Validacion cedula
                }
                else if (validadorDeCedula(cedula)){
                    if (clientes.buscarCliente(cedula)){
                    eventos.eliminarEvento(cedula);

                    String infoEvento = eventos.generarReporte();
                    txtAreaRegistrarEventos.setText(infoEvento);
                    txtAreaEditarEventos.setText(infoEvento);
            }}}
        });
        btnOrdenarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(eventos.getListaEventos().isEmpty()){
                    JOptionPane.showMessageDialog(null, "No hay eventos registrados", "Error", JOptionPane.ERROR_MESSAGE);
                }else if (eventos.getListaEventos().size()==1) {
                    JOptionPane.showMessageDialog(null, "Deben haber al menos 2 datos para ordenar","Error",JOptionPane.ERROR_MESSAGE);
                }else {
                String infoEvento = eventos.generarReporte();

                txtAreaRegistrarEventos.setText(infoEvento);
                txtAreaEditarEventos.setText(infoEvento);
            }}
        });

        btnAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tbTuberias.getSelectedRow() != -1) {
                    String nombreT=(String) dtmT.getValueAt(tbTuberias.getSelectedRow(), 0);
                    String estado=(String) dtmT.getValueAt(tbTuberias.getSelectedRow(), 1);
                    if(!estado.equals("Funcionamiento correcto"))
                    {
                       ST.cambioEstado(nombreT,estado);
                       JOptionPane.showMessageDialog(null,"Se ha enviado a alguien para la revision");
                       limpiarListaT();
                       actualizarListaTuberias();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"La tuberia no necesita atencion");
                    }

                }
                else {
                    JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna tuberia", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnAnomalia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String estado="";
                String nombreT=(String)cboTuberias.getSelectedItem();
                for(Tuberia p:ST.getListadoTuberias()){
                    if(nombreT.compareToIgnoreCase(p.getNombre())==0) {
                        estado=p.getEstado();
                    }
                }
                    String comentario=txtAnomalia.getText();
                    if(!estado.equalsIgnoreCase("Pendiente reparacion"))
                    {
                        ST.registroAnomalia(nombreT,comentario);
                        JOptionPane.showMessageDialog(null,"Se ha registrado la anomalia");
                        limpiarListaT();
                        actualizarListaTuberias();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"La tuberia ya se encuentra con fallos");
                    }
            }
        });
        buttonAsignarCasillero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genero=clientes.buscarGenero();
                arbol.asignarCasillero(genero);
                buttonAsignarCasillero.setEnabled(false);
                buttonEliminarCasillero.setVisible(true);
                buttonVisualizarCasillerosOcupados.setVisible(true);
            }
        });
        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contrasena="";
                String cedula=textCedulaCasilleros.getText();
                if(cedula.length()!=10){
                    JOptionPane.showMessageDialog(null, "Revise si se ingreso una cedula correcta");//Validacion cedula
                } else if (validadorDeCedula(cedula)) {
                contrasena=JOptionPane.showInputDialog("Ingrese la contrasena: ");
                if (clientes.buscarContrasena(contrasena)){

                    buttonAsignarCasillero.setEnabled(true);
                    buttonAsignarCasillero.setVisible(true);
                    buttonEliminarCasillero.setVisible(true);
                    buttonVisualizarCasillerosOcupados.setVisible(true);
                    buttonVisualizarCasillerosDisponibles.setVisible(true);
                }
                }
            }
        });
        buttonEliminarCasillero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int casillero=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el casillero que desea eliminar"));
                arbol.desocuparCasillero(casillero);

            }
        });
        buttonVisualizarCasillerosOcupados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               textArbolCasilleros.setText(arbol.imprimirCasillerosOcupados());

            }
        });
        buttonVisualizarCasillerosDisponibles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArbolCasilleros.setText(arbol.imprimirCasillerosDisponibles());
            }
        });
        textCedulaCasilleros.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                int tecla=e.getKeyChar();
                boolean numeros = tecla >=48 && tecla <=57;

                if(!numeros){
                    e.consume();
                }

                if (textCedulaCasilleros.getText().length()>=10){
                    e.consume();
                }
            }
        });
        textCedula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                int tecla=e.getKeyChar();
                boolean numeros = tecla >=48 && tecla <=57;

                if(!numeros){
                    e.consume();
                }

                if (textCedula.getText().length()>=10){
                    e.consume();
                }
            }
        });

        txtCedulaCliente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                int tecla=e.getKeyChar();
                boolean numeros = tecla >=48 && tecla <=57;

                if(!numeros){
                    e.consume();
                }

                if (txtCedulaCliente.getText().length()>=10){
                    e.consume();
                }
            }
        });
    }

    public void llenarTabla(){
        dlm.removeAllElements();

        for(Pedido obj:BC.listapedidos()){
            dlm.addElement(obj.toString());
        }
        list1.setModel(dlm);

    }

    public void actualizarLista(){
        for(Producto p:arreglo){
            Object[] fila={p.getNombre(),p.getDescripcion(),p.getPrecio(),p.getTipo(),p.getCantidad()};
            model.addRow(fila);}
    }

    public void actualizarListaTuberias(){
        for(Tuberia p:arregloTuberia){
            Object[] fila={p.getNombre(),p.getEstado(),p.getComentario(),p.getAbierto()};
            dtmT.addRow(fila);}
    }

    public void limpiarLista(){
        model.setNumRows(0);
        tbProductos.clearSelection();
    }
    public void limpiarListaT(){
        dtmT.setNumRows(0);
        tbTuberias.clearSelection();
    }

    public boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;
        try {
            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    // Coeficientes de validación cédula
                    // El decimo digito se lo considera dígito verificador

                    int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
                    int verificador = Integer.parseInt(cedula.substring(9,10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1))* coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;}
                    else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;}
                } else {
                    cedulaCorrecta = false;}
            } else {
                cedulaCorrecta = false;}
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Una excepcion ocurrio en el proceso de validacion","Error",JOptionPane.ERROR_MESSAGE);
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            JOptionPane.showMessageDialog(null, "Cedula no valida","Error",JOptionPane.ERROR_MESSAGE);
        }
        return cedulaCorrecta;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel1);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(800,700);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}


