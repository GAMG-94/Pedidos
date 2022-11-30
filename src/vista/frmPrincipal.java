package vista;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import modelo.Clientes;
import modelo.ClientesDAO;
import modelo.ExportarExcel;
import modelo.Productos;
import modelo.ProductosDAO;
import modelo.Proveedores;
import modelo.ProveedoresDAO;
import modelo.Ventas;
import modelo.VentasDAO;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class frmPrincipal extends javax.swing.JFrame {

    int articulo;
    double Totalpagar = 0.00;
    Date fechaVenta = new Date();
    String fechaActual = new SimpleDateFormat("dd/MM/yyyy").format(fechaVenta);
    Clientes cl = new Clientes();
    ClientesDAO cdao = new ClientesDAO();
    Proveedores pv = new Proveedores();
    ProveedoresDAO pdao = new ProveedoresDAO();
    Productos pro = new Productos();
    ProductosDAO ppro = new ProductosDAO();
    Ventas v = new Ventas();
    VentasDAO vDAO = new VentasDAO();

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel provee = new DefaultTableModel();
    DefaultTableModel produc = new DefaultTableModel();
    DefaultTableModel ventas = new DefaultTableModel();

    private int Id_Documento;
    private int NIT;
    private int Id_Producto;
    private int Id_Codigo;

    public frmPrincipal() {

        initComponents();

        setIconImage(new ImageIcon(getClass().getResource("/icono.png")).getImage());
        this.setLocationRelativeTo(null);
        ppro.ConsultarProveedor(cbxProveedor);

    }

    public void ListarCliente() {

        List<Clientes> ListaCl = cdao.ListarClientes();
        modelo = (DefaultTableModel) tablaClientes.getModel();
        Object[] obj = new Object[5];

        for (int i = 0; i < ListaCl.size(); i++) {

            obj[0] = ListaCl.get(i).getId_Documento();
            obj[1] = ListaCl.get(i).getNombre();
            obj[2] = ListaCl.get(i).getDireccion();
            obj[3] = ListaCl.get(i).getCelular();
            obj[4] = ListaCl.get(i).getCorreo();
            modelo.addRow(obj);
        }
        tablaClientes.setModel(modelo);

    }

    public void ListarProveedores() {

        List<Proveedores> ListaPv = pdao.ListarProveedores();
        provee = (DefaultTableModel) tablaProveedores.getModel();
        Object[] obj = new Object[5];

        for (int i = 0; i < ListaPv.size(); i++) {

            obj[0] = ListaPv.get(i).getNIT();
            obj[1] = ListaPv.get(i).getRazon_Social();
            obj[2] = ListaPv.get(i).getTelefono();
            obj[3] = ListaPv.get(i).getDireccion();
            obj[4] = ListaPv.get(i).getCorreo();
            provee.addRow(obj);
        }
        tablaProveedores.setModel(provee);
    }

    public void ListarProductos() {

        List<Productos> ListaPr = ppro.ListarProductos();
        produc = (DefaultTableModel) tablaProductos.getModel();
        Object[] obj = new Object[5];

        for (int i = 0; i < ListaPr.size(); i++) {

            obj[0] = ListaPr.get(i).getId_Producto();
            obj[1] = ListaPr.get(i).getNombre();
            obj[2] = ListaPr.get(i).getProveedor();
            obj[3] = ListaPr.get(i).getPrecio();
            obj[4] = ListaPr.get(i).getCantidad();
            produc.addRow(obj);
        }
        tablaProductos.setModel(produc);
    }

    public void LimpiarTabla() {

        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = -1;
        }
    }

    public void LimpiarTablaProvee() {

        for (int i = 0; i < provee.getRowCount(); i++) {
            provee.removeRow(i);
            i = -1;
        }
    }

    public void LimpiarTablaProductos() {

        for (int i = 0; i < produc.getRowCount(); i++) {
            produc.removeRow(i);
            i = -1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Imagen_Fondo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        pnlLocal = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        lblInicio = new javax.swing.JLabel();
        lblMenuPrincipal = new javax.swing.JLabel();
        lblClientes = new javax.swing.JLabel();
        lblProductos = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        lblProveedores = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        btnSalir = new javax.swing.JButton();
        lblVentas = new javax.swing.JLabel();
        pnlMenuPrincipal = new javax.swing.JPanel();
        pnlInicio = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        pnlClientes = new javax.swing.JPanel();
        lblClienteTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        pnlInfoClientes = new javax.swing.JPanel();
        txtDocCliente = new javax.swing.JTextField();
        txtNomCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDireCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTelCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCorreoCliente = new javax.swing.JTextField();
        btnReporte = new javax.swing.JButton();
        btnSaveCliente = new javax.swing.JButton();
        btnEditCliente = new javax.swing.JButton();
        btnNewCliente = new javax.swing.JButton();
        btnDeleteCliente = new javax.swing.JButton();
        pnlProveedores = new javax.swing.JPanel();
        lblClienteTitulo1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
        pnlDatosProveedor = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNITProveedor = new javax.swing.JTextField();
        txtRazonSocProveedor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelProveedor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDireProveedor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCorreoProveedor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnSaveProveedor = new javax.swing.JButton();
        btnEditProveedor = new javax.swing.JButton();
        btnNewProveedor = new javax.swing.JButton();
        btnDeleteProveedor = new javax.swing.JButton();
        pnlProductos = new javax.swing.JPanel();
        lblInicioTitulo1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        pnlInfoProducto = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtIdProductos = new javax.swing.JTextField();
        txtNomProductos = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtCantProductos = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtPrecioProductos = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cbxProveedor = new javax.swing.JComboBox<>();
        btnSaveProductos = new javax.swing.JButton();
        btnEditProductos = new javax.swing.JButton();
        btnNewProductos = new javax.swing.JButton();
        btnDeleteProductos = new javax.swing.JButton();
        pnlVentas = new javax.swing.JPanel();
        lblClienteTitulo2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        pnlInfoVentas = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtCodVentas = new javax.swing.JTextField();
        txtDescVentas = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtCantVentas = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtPrecioVentas = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtTotalaPagar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtNomVentas = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        btnSaveVentas = new javax.swing.JButton();
        btnEditVentas = new javax.swing.JButton();
        btnNewVentas = new javax.swing.JButton();
        btnDeleteVentas = new javax.swing.JButton();
        btnTarjetaVentas = new javax.swing.JButton();

        Imagen_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Sin título-1.jpg"))); // NOI18N

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión De Pedidos 2.0");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        pnlLocal.setBackground(new java.awt.Color(255, 255, 255));
        pnlLocal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(255, 102, 0));

        lblInicio.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInicio.setText("Inicio");
        lblInicio.setToolTipText("Página Principal");
        lblInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInicioMouseClicked(evt);
            }
        });

        lblMenuPrincipal.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblMenuPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuPrincipal.setText("MENÚ PRINCIPAL");

        lblClientes.setBackground(new java.awt.Color(0, 0, 0));
        lblClientes.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblClientes.setForeground(new java.awt.Color(255, 255, 255));
        lblClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClientes.setText("Clientes");
        lblClientes.setToolTipText("Información Clientes");
        lblClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClientesMouseClicked(evt);
            }
        });

        lblProductos.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblProductos.setForeground(new java.awt.Color(255, 255, 255));
        lblProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductos.setText("Productos");
        lblProductos.setToolTipText("Información Productos");
        lblProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProductosMouseClicked(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        lblProveedores.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblProveedores.setForeground(new java.awt.Color(255, 255, 255));
        lblProveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProveedores.setText("Proveedores");
        lblProveedores.setToolTipText("Información Proveedores");
        lblProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProveedoresMouseClicked(evt);
            }
        });

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Windows_Close_Program_22531.png"))); // NOI18N
        btnSalir.setToolTipText("Salir Del Programa");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblVentas.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblVentas.setForeground(new java.awt.Color(255, 255, 255));
        lblVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVentas.setText("Ventas");
        lblVentas.setToolTipText("Nuevas Ventas");
        lblVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVentasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator5)
                                .addComponent(lblProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addComponent(lblClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addComponent(lblInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator2)
                                .addComponent(jSeparator1)
                                .addComponent(jSeparator6)
                                .addComponent(jSeparator4)
                                .addComponent(jSeparator3)
                                .addComponent(lblVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                            .addComponent(lblMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(314, 314, 314))
        );

        pnlLocal.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 228, 660));

        pnlMenuPrincipal.setLayout(new java.awt.CardLayout());

        pnlInicio.setBackground(new java.awt.Color(255, 255, 255));
        pnlInicio.setName(""); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Sin título-1.jpg"))); // NOI18N

        javax.swing.GroupLayout pnlInicioLayout = new javax.swing.GroupLayout(pnlInicio);
        pnlInicio.setLayout(pnlInicioLayout);
        pnlInicioLayout.setHorizontalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlInicioLayout.setVerticalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMenuPrincipal.add(pnlInicio, "card2");

        pnlClientes.setBackground(new java.awt.Color(255, 255, 255));

        lblClienteTitulo.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblClienteTitulo.setText("Clientes");

        tablaClientes.setBackground(new java.awt.Color(255, 255, 255));
        tablaClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Documento", "Nombre", "Dirección", "Celular", "E-Mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.setGridColor(new java.awt.Color(255, 255, 255));
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaClientes.getColumnModel().getColumn(1).setPreferredWidth(100);
            tablaClientes.getColumnModel().getColumn(2).setPreferredWidth(70);
            tablaClientes.getColumnModel().getColumn(3).setPreferredWidth(50);
            tablaClientes.getColumnModel().getColumn(4).setPreferredWidth(90);
        }

        pnlInfoClientes.setBackground(new java.awt.Color(255, 255, 255));
        pnlInfoClientes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "   Información   ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto Black", 0, 16), new java.awt.Color(0, 51, 102))); // NOI18N

        txtDocCliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtDocCliente.setForeground(new java.awt.Color(0, 51, 102));

        txtNomCliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNomCliente.setForeground(new java.awt.Color(0, 51, 102));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Nombre");

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Documento");

        txtDireCliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtDireCliente.setForeground(new java.awt.Color(0, 51, 102));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Dirección");

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 102));
        jLabel4.setText("Teléfono");

        txtTelCliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTelCliente.setForeground(new java.awt.Color(0, 51, 102));

        jLabel5.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 102));
        jLabel5.setText("Correo");

        txtCorreoCliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtCorreoCliente.setForeground(new java.awt.Color(0, 51, 102));

        btnReporte.setBackground(new java.awt.Color(0, 102, 0));
        btnReporte.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/microsoft_excel_macos_bigsur_icon_189980.png"))); // NOI18N
        btnReporte.setText("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInfoClientesLayout = new javax.swing.GroupLayout(pnlInfoClientes);
        pnlInfoClientes.setLayout(pnlInfoClientesLayout);
        pnlInfoClientesLayout.setHorizontalGroup(
            pnlInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoClientesLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(pnlInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtTelCliente, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtDocCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCorreoCliente, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNomCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtDireCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporte))
                .addGap(29, 29, 29))
        );
        pnlInfoClientesLayout.setVerticalGroup(
            pnlInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoClientesLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnlInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDocCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoClientesLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnlInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlInfoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlInfoClientesLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnReporte)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        btnSaveCliente.setBackground(new java.awt.Color(0, 153, 0));
        btnSaveCliente.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnSaveCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/savedisk_floppydisk_guardar_1543.png"))); // NOI18N
        btnSaveCliente.setText("  Guardar");
        btnSaveCliente.setToolTipText("Guardar Datos");
        btnSaveCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveClienteActionPerformed(evt);
            }
        });

        btnEditCliente.setBackground(new java.awt.Color(0, 51, 255));
        btnEditCliente.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnEditCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnEditCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/systemsoftwareupdate_94333.png"))); // NOI18N
        btnEditCliente.setText("  Editar");
        btnEditCliente.setToolTipText("Actualizar Datos");
        btnEditCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditClienteActionPerformed(evt);
            }
        });

        btnNewCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnNewCliente.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnNewCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1486485557-add-create-new-more-plus_81188.png"))); // NOI18N
        btnNewCliente.setText("  Nuevo");
        btnNewCliente.setToolTipText("Ingresa Nuevos Datos");
        btnNewCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewClienteActionPerformed(evt);
            }
        });

        btnDeleteCliente.setBackground(new java.awt.Color(255, 102, 0));
        btnDeleteCliente.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnDeleteCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_delete_exit_1577.png"))); // NOI18N
        btnDeleteCliente.setText("  Eliminar");
        btnDeleteCliente.setToolTipText("Borrar Datos");
        btnDeleteCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlClientesLayout = new javax.swing.GroupLayout(pnlClientes);
        pnlClientes.setLayout(pnlClientesLayout);
        pnlClientesLayout.setHorizontalGroup(
            pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClientesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblClienteTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClientesLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClientesLayout.createSequentialGroup()
                        .addComponent(pnlInfoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSaveCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteCliente, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(108, 108, 108))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClientesLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        pnlClientesLayout.setVerticalGroup(
            pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClientesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblClienteTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlClientesLayout.createSequentialGroup()
                        .addComponent(btnSaveCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btnNewCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlInfoClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pnlMenuPrincipal.add(pnlClientes, "card3");

        pnlProveedores.setBackground(new java.awt.Color(255, 255, 255));

        lblClienteTitulo1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblClienteTitulo1.setText("Proveedores");

        tablaProveedores.setBackground(new java.awt.Color(255, 255, 255));
        tablaProveedores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIT", "Razón Social", "Teléfono", "Dirección", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProveedores.setGridColor(new java.awt.Color(255, 255, 255));
        tablaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProveedoresMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaProveedores);
        if (tablaProveedores.getColumnModel().getColumnCount() > 0) {
            tablaProveedores.getColumnModel().getColumn(0).setPreferredWidth(20);
            tablaProveedores.getColumnModel().getColumn(1).setPreferredWidth(120);
            tablaProveedores.getColumnModel().getColumn(2).setPreferredWidth(30);
            tablaProveedores.getColumnModel().getColumn(3).setPreferredWidth(20);
            tablaProveedores.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        pnlDatosProveedor.setBackground(new java.awt.Color(255, 255, 255));
        pnlDatosProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "   Datos Proveedor   ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto Black", 0, 16), new java.awt.Color(0, 51, 102))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("NIT");

        txtNITProveedor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        txtRazonSocProveedor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 102));
        jLabel7.setText("Razón Social");

        txtTelProveedor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 102));
        jLabel8.setText("Teléfono");

        txtDireProveedor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setText("Dirección");

        txtCorreoProveedor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setText("Correo");

        javax.swing.GroupLayout pnlDatosProveedorLayout = new javax.swing.GroupLayout(pnlDatosProveedor);
        pnlDatosProveedor.setLayout(pnlDatosProveedorLayout);
        pnlDatosProveedorLayout.setHorizontalGroup(
            pnlDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosProveedorLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDireProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                        .addComponent(txtNITProveedor)
                        .addComponent(jLabel6))
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosProveedorLayout.createSequentialGroup()
                        .addGroup(pnlDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRazonSocProveedor)
                            .addComponent(jLabel7)
                            .addComponent(txtCorreoProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtTelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnlDatosProveedorLayout.setVerticalGroup(
            pnlDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosProveedorLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnlDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNITProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazonSocProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(pnlDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        btnSaveProveedor.setBackground(new java.awt.Color(0, 153, 0));
        btnSaveProveedor.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnSaveProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/savedisk_floppydisk_guardar_1543.png"))); // NOI18N
        btnSaveProveedor.setText("  Guardar");
        btnSaveProveedor.setToolTipText("Guardar Datos");
        btnSaveProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProveedorActionPerformed(evt);
            }
        });

        btnEditProveedor.setBackground(new java.awt.Color(0, 102, 255));
        btnEditProveedor.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnEditProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnEditProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/systemsoftwareupdate_94333.png"))); // NOI18N
        btnEditProveedor.setText("  Editar");
        btnEditProveedor.setToolTipText("Actualizar Datos");
        btnEditProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProveedorActionPerformed(evt);
            }
        });

        btnNewProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnNewProveedor.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnNewProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1486485557-add-create-new-more-plus_81188.png"))); // NOI18N
        btnNewProveedor.setText("  Nuevo");
        btnNewProveedor.setToolTipText("Ingresa Nuevos Datos");
        btnNewProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProveedorActionPerformed(evt);
            }
        });

        btnDeleteProveedor.setBackground(new java.awt.Color(255, 102, 0));
        btnDeleteProveedor.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnDeleteProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_delete_exit_1577.png"))); // NOI18N
        btnDeleteProveedor.setText("  Eliminar");
        btnDeleteProveedor.setToolTipText("Borrar Datos");
        btnDeleteProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProveedoresLayout = new javax.swing.GroupLayout(pnlProveedores);
        pnlProveedores.setLayout(pnlProveedoresLayout);
        pnlProveedoresLayout.setHorizontalGroup(
            pnlProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProveedoresLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblClienteTitulo1)
                .addContainerGap(711, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProveedoresLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlProveedoresLayout.createSequentialGroup()
                        .addComponent(pnlDatosProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSaveProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNewProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeleteProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );
        pnlProveedoresLayout.setVerticalGroup(
            pnlProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProveedoresLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblClienteTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(pnlProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlProveedoresLayout.createSequentialGroup()
                        .addComponent(btnSaveProveedor)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditProveedor)
                        .addGap(18, 18, 18)
                        .addComponent(btnNewProveedor)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteProveedor))
                    .addComponent(pnlDatosProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pnlMenuPrincipal.add(pnlProveedores, "card6");

        pnlProductos.setBackground(new java.awt.Color(255, 255, 255));

        lblInicioTitulo1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblInicioTitulo1.setText("Productos");

        tablaProductos.setBackground(new java.awt.Color(255, 255, 255));
        tablaProductos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Proveedor", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.setGridColor(new java.awt.Color(255, 255, 255));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(20);
            tablaProductos.getColumnModel().getColumn(1).setPreferredWidth(120);
            tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(40);
            tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(30);
            tablaProductos.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        pnlInfoProducto.setBackground(new java.awt.Color(255, 255, 255));
        pnlInfoProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "   Información Producto   ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto Black", 0, 16), new java.awt.Color(0, 51, 102))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 102));
        jLabel21.setText("Código");

        txtIdProductos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        txtNomProductos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 102));
        jLabel22.setText("Descripción");

        txtCantProductos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 51, 102));
        jLabel23.setText("Cantidad");

        txtPrecioProductos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 51, 102));
        jLabel24.setText("Precio");

        jLabel25.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 51, 102));
        jLabel25.setText("Proveedor");

        cbxProveedor.setEditable(true);
        cbxProveedor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbxProveedor.setMaximumRowCount(20);
        cbxProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----  Seleccionar  ----" }));
        cbxProveedor.setSelectedIndex(getCursorType());
        cbxProveedor.setToolTipText("");
        cbxProveedor.setName(""); // NOI18N

        javax.swing.GroupLayout pnlInfoProductoLayout = new javax.swing.GroupLayout(pnlInfoProducto);
        pnlInfoProducto.setLayout(pnlInfoProductoLayout);
        pnlInfoProductoLayout.setHorizontalGroup(
            pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoProductoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPrecioProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                        .addComponent(txtIdProductos)
                        .addComponent(jLabel21))
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoProductoLayout.createSequentialGroup()
                        .addGroup(pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNomProductos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(txtCantProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel25)
                    .addComponent(cbxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        pnlInfoProductoLayout.setVerticalGroup(
            pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoProductoLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        btnSaveProductos.setBackground(new java.awt.Color(0, 153, 0));
        btnSaveProductos.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnSaveProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/savedisk_floppydisk_guardar_1543.png"))); // NOI18N
        btnSaveProductos.setText("  Guardar");
        btnSaveProductos.setToolTipText("Guardar Datos");
        btnSaveProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProductosActionPerformed(evt);
            }
        });

        btnEditProductos.setBackground(new java.awt.Color(0, 102, 255));
        btnEditProductos.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnEditProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnEditProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/systemsoftwareupdate_94333.png"))); // NOI18N
        btnEditProductos.setText("  Editar");
        btnEditProductos.setToolTipText("Actualizar Datos");
        btnEditProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProductosActionPerformed(evt);
            }
        });

        btnNewProductos.setBackground(new java.awt.Color(255, 255, 255));
        btnNewProductos.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnNewProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1486485557-add-create-new-more-plus_81188.png"))); // NOI18N
        btnNewProductos.setText("  Nuevo");
        btnNewProductos.setToolTipText("Ingresar Nuevos Datos");
        btnNewProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProductosActionPerformed(evt);
            }
        });

        btnDeleteProductos.setBackground(new java.awt.Color(255, 102, 0));
        btnDeleteProductos.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnDeleteProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_delete_exit_1577.png"))); // NOI18N
        btnDeleteProductos.setText("  Eliminar");
        btnDeleteProductos.setToolTipText("Borrar Datos");
        btnDeleteProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProductosLayout = new javax.swing.GroupLayout(pnlProductos);
        pnlProductos.setLayout(pnlProductosLayout);
        pnlProductosLayout.setHorizontalGroup(
            pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblInicioTitulo1)
                .addContainerGap(735, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlProductosLayout.createSequentialGroup()
                        .addComponent(pnlInfoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSaveProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNewProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeleteProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );
        pnlProductosLayout.setVerticalGroup(
            pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblInicioTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProductosLayout.createSequentialGroup()
                        .addComponent(pnlInfoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(pnlProductosLayout.createSequentialGroup()
                        .addComponent(btnSaveProductos)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditProductos)
                        .addGap(18, 18, 18)
                        .addComponent(btnNewProductos)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteProductos)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pnlMenuPrincipal.add(pnlProductos, "card4");

        pnlVentas.setBackground(new java.awt.Color(255, 255, 255));

        lblClienteTitulo2.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        lblClienteTitulo2.setText("Ventas");

        tablaVentas.setBackground(new java.awt.Color(255, 255, 255));
        tablaVentas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Cantidad", "Precio", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVentas.setGridColor(new java.awt.Color(255, 255, 255));
        tablaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVentasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaVentas);
        if (tablaVentas.getColumnModel().getColumnCount() > 0) {
            tablaVentas.getColumnModel().getColumn(0).setPreferredWidth(20);
            tablaVentas.getColumnModel().getColumn(1).setPreferredWidth(120);
            tablaVentas.getColumnModel().getColumn(2).setPreferredWidth(20);
            tablaVentas.getColumnModel().getColumn(3).setPreferredWidth(30);
            tablaVentas.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        pnlInfoVentas.setBackground(new java.awt.Color(255, 255, 255));
        pnlInfoVentas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "   Información De Venta   ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto Black", 0, 16), new java.awt.Color(0, 51, 102))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 51, 102));
        jLabel26.setText("Código");

        txtCodVentas.setBackground(new java.awt.Color(255, 255, 255));
        txtCodVentas.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtCodVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodVentasKeyPressed(evt);
            }
        });

        txtDescVentas.setBackground(new java.awt.Color(255, 255, 255));
        txtDescVentas.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 51, 102));
        jLabel27.setText("Descripción");

        txtCantVentas.setBackground(new java.awt.Color(255, 255, 255));
        txtCantVentas.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtCantVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantVentasKeyPressed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 51, 102));
        jLabel28.setText("Cantidad");

        txtPrecioVentas.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecioVentas.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 51, 102));
        jLabel29.setText("Precio");

        jLabel33.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 51, 102));
        jLabel33.setText("Total A Pagar");

        txtTotalaPagar.setEditable(false);
        txtTotalaPagar.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalaPagar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTotalaPagar.setToolTipText("Total De La Compra");
        txtTotalaPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalaPagarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setText("Seleccione Fecha");

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlInfoVentasLayout = new javax.swing.GroupLayout(pnlInfoVentas);
        pnlInfoVentas.setLayout(pnlInfoVentasLayout);
        pnlInfoVentasLayout.setHorizontalGroup(
            pnlInfoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoVentasLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlInfoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoVentasLayout.createSequentialGroup()
                        .addGroup(pnlInfoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInfoVentasLayout.createSequentialGroup()
                                .addGroup(pnlInfoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrecioVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(jLabel29))
                                .addGap(18, 18, 18)
                                .addGroup(pnlInfoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel33)
                                    .addComponent(txtTotalaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlInfoVentasLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(181, 181, 181))
                    .addGroup(pnlInfoVentasLayout.createSequentialGroup()
                        .addGroup(pnlInfoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlInfoVentasLayout.createSequentialGroup()
                                .addGroup(pnlInfoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26))
                                .addGap(18, 18, 18)
                                .addGroup(pnlInfoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDescVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addGap(18, 18, 18)
                                .addGroup(pnlInfoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(txtCantVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlInfoVentasLayout.setVerticalGroup(
            pnlInfoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoVentasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlInfoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInfoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlInfoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInfoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtNomVentas.setEditable(false);
        txtNomVentas.setBackground(new java.awt.Color(255, 255, 255));
        txtNomVentas.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNomVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomVentasActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 51, 102));
        jLabel32.setText("Nombre Del Cliente");

        btnSaveVentas.setBackground(new java.awt.Color(0, 153, 0));
        btnSaveVentas.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnSaveVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/savedisk_floppydisk_guardar_1543.png"))); // NOI18N
        btnSaveVentas.setText("  Guardar");
        btnSaveVentas.setToolTipText("Guardar Datos");

        btnEditVentas.setBackground(new java.awt.Color(0, 102, 255));
        btnEditVentas.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnEditVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnEditVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/systemsoftwareupdate_94333.png"))); // NOI18N
        btnEditVentas.setText("  Editar");
        btnEditVentas.setToolTipText("Actualizar Datos");

        btnNewVentas.setBackground(new java.awt.Color(255, 255, 255));
        btnNewVentas.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnNewVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1486485557-add-create-new-more-plus_81188.png"))); // NOI18N
        btnNewVentas.setText("  Nuevo");
        btnNewVentas.setToolTipText("Ingresar Nuevos Datos");

        btnDeleteVentas.setBackground(new java.awt.Color(255, 102, 0));
        btnDeleteVentas.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnDeleteVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_delete_exit_1577.png"))); // NOI18N
        btnDeleteVentas.setText("  Eliminar");
        btnDeleteVentas.setToolTipText("Borrar Datos");
        btnDeleteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteVentasActionPerformed(evt);
            }
        });

        btnTarjetaVentas.setBackground(new java.awt.Color(255, 204, 0));
        btnTarjetaVentas.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btnTarjetaVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/payment_paymentcard_card_2804.png"))); // NOI18N
        btnTarjetaVentas.setText("  Tarjeta");
        btnTarjetaVentas.setToolTipText("Pago Con Tarjeta");

        javax.swing.GroupLayout pnlVentasLayout = new javax.swing.GroupLayout(pnlVentas);
        pnlVentas.setLayout(pnlVentasLayout);
        pnlVentasLayout.setHorizontalGroup(
            pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentasLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblClienteTitulo2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlVentasLayout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addGroup(pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlVentasLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(txtNomVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTarjetaVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlVentasLayout.createSequentialGroup()
                        .addComponent(pnlInfoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnEditVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSaveVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeleteVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNewVentas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        pnlVentasLayout.setVerticalGroup(
            pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVentasLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblClienteTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlVentasLayout.createSequentialGroup()
                        .addComponent(btnSaveVentas)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditVentas)
                        .addGap(18, 18, 18)
                        .addComponent(btnNewVentas)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlInfoVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVentasLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVentasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTarjetaVentas)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pnlMenuPrincipal.add(pnlVentas, "card5");
        pnlVentas.getAccessibleContext().setAccessibleName("Ventas");
        pnlVentas.getAccessibleContext().setAccessibleDescription("Ventas");

        pnlLocal.add(pnlMenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 0, 852, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveClienteActionPerformed

        if (!"".equals(txtDocCliente.getText()) && !"".equals(txtNomCliente.getText()) && !"".equals(txtDireCliente.getText())
                && !"".equals(txtTelCliente.getText()) && !"".equals(txtCorreoCliente.getText())) {

            cl.setId_Documento(Integer.parseInt(txtDocCliente.getText()));
            cl.setNombre(txtNomCliente.getText());
            cl.setDireccion(txtDireCliente.getText());
            cl.setCelular(Integer.parseInt(txtTelCliente.getText()));
            cl.setCorreo(txtCorreoCliente.getText());
            cdao.RegistrarCliente(cl);
            LimpiarTabla();
            LimpiarClientes();
            ListarCliente();

            JOptionPane.showMessageDialog(this, "Cliente Registrado", "Registro", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "Los Campos Están Vacios", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSaveClienteActionPerformed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked

        int fila = tablaClientes.rowAtPoint(evt.getPoint());
        txtDocCliente.setText(tablaClientes.getValueAt(fila, 0).toString());
        txtNomCliente.setText(tablaClientes.getValueAt(fila, 1).toString());
        txtDireCliente.setText(tablaClientes.getValueAt(fila, 2).toString());
        txtTelCliente.setText(tablaClientes.getValueAt(fila, 3).toString());
        txtCorreoCliente.setText(tablaClientes.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void btnDeleteClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteClienteActionPerformed

        if (!"".equals(txtDocCliente.getText())) {
            int borrar = JOptionPane.showConfirmDialog(this, "¿Desea Eliminar La Información?", "Borrar", JOptionPane.OK_OPTION);
            if (borrar == 0) {
                int Id_Documento = Integer.parseInt(txtDocCliente.getText());
                cdao.EliminarClientes(Id_Documento);
                LimpiarTabla();
                LimpiarClientes();
                ListarCliente();
            }
        }
    }//GEN-LAST:event_btnDeleteClienteActionPerformed

    private void btnEditClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditClienteActionPerformed

        if (!"".equals(txtDocCliente.getText())) {
            JOptionPane.showMessageDialog(this, "Seleccione Una Fila", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            if (!"".equals(txtDocCliente.getText()) && !"".equals(txtNomCliente.getText()) && !"".equals(txtDireCliente.getText())
                    && !"".equals(txtTelCliente.getText()) && !"".equals(txtCorreoCliente.getText())) {

                cl.setId_Documento(Integer.parseInt(txtDocCliente.getText()));
                cl.setNombre(txtNomCliente.getText());
                cl.setDireccion(txtDireCliente.getText());
                cl.setCelular(Integer.parseInt(txtTelCliente.getText()));
                cl.setCorreo(txtCorreoCliente.getText());
                cdao.ActualizarClientes(cl);
                LimpiarTabla();
                LimpiarClientes();
                ListarCliente();

            } else {
                JOptionPane.showMessageDialog(this, "Los Campos Están Vacios", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_btnEditClienteActionPerformed

    private void btnSaveProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProveedorActionPerformed

        if (!"".equals(txtNITProveedor.getText()) && !"".equals(txtRazonSocProveedor.getText()) && !"".equals(txtDireProveedor.getText())
                && !"".equals(txtTelProveedor.getText()) && !"".equals(txtCorreoProveedor.getText())) {

            pv.setNIT(Integer.parseInt(txtNITProveedor.getText()));
            pv.setRazon_Social(txtRazonSocProveedor.getText());
            pv.setDireccion(txtDireProveedor.getText());
            pv.setTelefono(Integer.parseInt(txtTelProveedor.getText()));
            pv.setCorreo(txtCorreoProveedor.getText());
            pdao.RegistrarProveedor(pv);
            LimpiarTablaProvee();
            LimpiarProveedores();
            ListarProveedores();

            JOptionPane.showMessageDialog(this, "Proveedor Registrado", "Registro", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "Los Campos Están Vacios", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSaveProveedorActionPerformed

    private void btnDeleteProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProveedorActionPerformed

        if (!"".equals(txtNITProveedor.getText())) {
            int borrar = JOptionPane.showConfirmDialog(this, "¿Desea Eliminar La Información?", "Borrar", JOptionPane.OK_OPTION);
            if (borrar == 0) {
                int NIT = Integer.parseInt(txtNITProveedor.getText());
                pdao.EliminarProveedores(NIT);
                LimpiarTablaProvee();
                LimpiarProveedores();
                ListarProveedores();
            }
        }

    }//GEN-LAST:event_btnDeleteProveedorActionPerformed

    private void btnEditProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProveedorActionPerformed

        if (!"".equals(txtNITProveedor.getText())) {
            JOptionPane.showMessageDialog(this, "Seleccione Una Fila", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            if ("".equals(txtNITProveedor.getText()) || "".equals(txtRazonSocProveedor.getText()) || "".equals(txtTelProveedor.getText())
                    || "".equals(txtDireCliente.getText()) || "".equals(txtCorreoProveedor.getText())) {

                pv.setNIT(Integer.parseInt(txtNITProveedor.getText()));
                pv.setRazon_Social(txtRazonSocProveedor.getText());
                pv.setTelefono(Integer.parseInt(txtTelProveedor.getText()));
                pv.setDireccion(txtDireProveedor.getText());
                pv.setCorreo(txtCorreoProveedor.getText());
                pdao.ActualizarProveedores(pv);
                LimpiarTablaProvee();
                LimpiarProveedores();
                ListarProveedores();

                JOptionPane.showMessageDialog(this, "La Información Se Ha Actualizado", "Actualizar", JOptionPane.INFORMATION_MESSAGE);

            } else {

                JOptionPane.showMessageDialog(this, "Los Campos Están Vacios", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_btnEditProveedorActionPerformed

    private void btnDeleteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteVentasActionPerformed
    }//GEN-LAST:event_btnDeleteVentasActionPerformed

    private void tablaProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProveedoresMouseClicked

        int fila = tablaProveedores.rowAtPoint(evt.getPoint());
        txtNITProveedor.setText(tablaProveedores.getValueAt(fila, 0).toString());
        txtRazonSocProveedor.setText(tablaProveedores.getValueAt(fila, 1).toString());
        txtTelProveedor.setText(tablaProveedores.getValueAt(fila, 2).toString());
        txtDireProveedor.setText(tablaProveedores.getValueAt(fila, 3).toString());
        txtCorreoProveedor.setText(tablaProveedores.getValueAt(fila, 4).toString());

    }//GEN-LAST:event_tablaProveedoresMouseClicked

    private void btnSaveProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProductosActionPerformed

        if (!"".equals(txtIdProductos.getText()) && !"".equals(txtNomProductos.getText()) || !"".equals(cbxProveedor.getSelectedItem())
                && !"".equals(txtPrecioProductos.getText()) && !"".equals(txtCantProductos.getText())) {

            pro.setId_Producto(Integer.parseInt(txtIdProductos.getText()));
            pro.setNombre(txtNomProductos.getText());
            pro.setProveedor(cbxProveedor.getSelectedItem().toString());
            pro.setPrecio(Double.parseDouble(txtPrecioProductos.getText()));
            pro.setCantidad(Integer.parseInt(txtCantProductos.getText()));
            ppro.RegistrarProductos(pro);
            LimpiarTablaProductos();
            LimpiarProductos();
            ListarProductos();

            JOptionPane.showMessageDialog(this, "Producto Registrado", "Registro", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "Los Campos Están Vacios", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSaveProductosActionPerformed

    private void btnDeleteProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductosActionPerformed

        if (!"".equals(txtIdProductos.getText())) {
            int borrar = JOptionPane.showConfirmDialog(this, "¿Desea Eliminar La Información?", "Borrar", JOptionPane.OK_OPTION);
            if (borrar == 0) {
                int Id_Producto = Integer.parseInt(txtIdProductos.getText());
                ppro.EliminarProductos(Id_Producto);
                LimpiarTablaProductos();
                LimpiarProductos();
                ListarProductos();
            }
        }
    }//GEN-LAST:event_btnDeleteProductosActionPerformed

    private void btnNewProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProductosActionPerformed
        LimpiarProductos();
    }//GEN-LAST:event_btnNewProductosActionPerformed

    private void btnNewProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProveedorActionPerformed

        LimpiarProveedores();
    }//GEN-LAST:event_btnNewProveedorActionPerformed

    private void btnNewClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewClienteActionPerformed
        LimpiarClientes();
    }//GEN-LAST:event_btnNewClienteActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked

        int fila = tablaProductos.rowAtPoint(evt.getPoint());
        txtIdProductos.setText(tablaProductos.getValueAt(fila, 0).toString());
        txtNomProductos.setText(tablaProductos.getValueAt(fila, 1).toString());
        cbxProveedor.setSelectedItem(tablaProductos.getValueAt(fila, 2));
        txtPrecioProductos.setText(tablaProductos.getValueAt(fila, 3).toString());
        txtCantProductos.setText(tablaProductos.getValueAt(fila, 4).toString());

    }//GEN-LAST:event_tablaProductosMouseClicked

    private void tablaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentasMouseClicked

        int fila = tablaVentas.rowAtPoint(evt.getPoint());
        txtCodVentas.setText(tablaVentas.getValueAt(fila, 0).toString());
        txtDescVentas.setText(tablaVentas.getValueAt(fila, 1).toString());
        txtPrecioVentas.setText(tablaVentas.getValueAt(fila, 2).toString());
        txtCantVentas.setText(tablaVentas.getValueAt(fila, 3).toString());

    }//GEN-LAST:event_tablaVentasMouseClicked

    private void txtTotalaPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalaPagarActionPerformed

    }//GEN-LAST:event_txtTotalaPagarActionPerformed

    private void btnEditProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProductosActionPerformed

        if (!"".equals(txtIdProductos.getText())) {
            JOptionPane.showMessageDialog(this, "Seleccione Una Fila", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            if (!"".equals(txtCodVentas.getText()) && !"".equals(txtNomProductos.getText()) && !"".equals(cbxProveedor.getSelectedItem())
                    && !"".equals(txtPrecioProductos.getText()) && !"".equals(txtCantProductos.getText())) {

                pro.setId_Producto(Integer.parseInt(txtIdProductos.getText()));
                pro.setNombre(txtNomProductos.getText());
                pro.setProveedor(cbxProveedor.getSelectedItem().toString());
                pro.setPrecio(Double.parseDouble(txtPrecioProductos.getText()));
                pro.setCantidad(Integer.parseInt(txtCorreoProveedor.getText()));
                ppro.AtcualizarProductos(pro);
                LimpiarTablaProductos();
                LimpiarProductos();
                ListarProductos();

                JOptionPane.showMessageDialog(this, "La Información Se Ha Actualizado", "Actualizar", JOptionPane.OK_OPTION);

            } else {

                JOptionPane.showMessageDialog(this, "Los Campos Están Vacios", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }

    }//GEN-LAST:event_btnEditProductosActionPerformed

    private void txtCantVentasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantVentasKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(Integer.parseInt(txtCantVentas.getText()))) {
                String cod = txtCodVentas.getText();
                String Desc = txtDescVentas.getText();
                int Cant = Integer.parseInt(txtCantVentas.getText());
                double precio = Double.parseDouble(txtPrecioVentas.getText());
                double total = Cant * precio;
                articulo = articulo + 1;
                ventas = (DefaultTableModel) tablaVentas.getModel();
                ArrayList lista = new ArrayList();
                lista.add(articulo);
                lista.add(cod);
                lista.add(Desc);
                lista.add(Cant);
                lista.add(precio);
                lista.add(total);
                Object[] obj = new Object[5];
                obj[0] = lista.get(1);
                obj[1] = lista.get(2);
                obj[2] = lista.get(3);
                obj[3] = lista.get(4);
                obj[4] = lista.get(5);
                ventas.addRow(obj);
                tablaVentas.setModel(ventas);

            }
        }

    }//GEN-LAST:event_txtCantVentasKeyPressed

    private void txtCodVentasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodVentasKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtCodVentas.getText())) {
                String cod = txtCodVentas.getText();
                pro = ppro.BuscarProd(cod);

            }
        }

    }//GEN-LAST:event_txtCodVentasKeyPressed

    private void lblVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVentasMouseClicked

        pnlInicio.setVisible(false);
        pnlClientes.setVisible(false);
        pnlProveedores.setVisible(false);
        pnlProductos.setVisible(false);
        pnlVentas.setVisible(true);
    }//GEN-LAST:event_lblVentasMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        int salir = JOptionPane.showConfirmDialog(this, "¿Desea Salir?", "Salir", JOptionPane.YES_NO_OPTION);
        if (salir == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void lblProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProveedoresMouseClicked

        pnlInicio.setVisible(false);
        pnlClientes.setVisible(false);
        pnlProveedores.setVisible(true);
        pnlProductos.setVisible(false);
        pnlVentas.setVisible(false);
    }//GEN-LAST:event_lblProveedoresMouseClicked

    private void lblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProductosMouseClicked

        pnlInicio.setVisible(false);
        pnlClientes.setVisible(false);
        pnlProveedores.setVisible(false);
        pnlProductos.setVisible(true);
        pnlVentas.setVisible(false);
    }//GEN-LAST:event_lblProductosMouseClicked

    private void lblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClientesMouseClicked

        pnlInicio.setVisible(false);
        pnlClientes.setVisible(true);
        pnlProveedores.setVisible(false);
        pnlProductos.setVisible(false);
        pnlVentas.setVisible(false);
    }//GEN-LAST:event_lblClientesMouseClicked

    private void lblInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInicioMouseClicked

        pnlInicio.setVisible(true);
        pnlClientes.setVisible(false);
        pnlProveedores.setVisible(false);
        pnlProductos.setVisible(false);
        pnlVentas.setVisible(false);
    }//GEN-LAST:event_lblInicioMouseClicked

    private void txtNomVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomVentasActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        
    }//GEN-LAST:event_btnReporteActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Imagen_Fondo;
    private javax.swing.JButton btnDeleteCliente;
    private javax.swing.JButton btnDeleteProductos;
    private javax.swing.JButton btnDeleteProveedor;
    private javax.swing.JButton btnDeleteVentas;
    private javax.swing.JButton btnEditCliente;
    private javax.swing.JButton btnEditProductos;
    private javax.swing.JButton btnEditProveedor;
    private javax.swing.JButton btnEditVentas;
    private javax.swing.JButton btnNewCliente;
    private javax.swing.JButton btnNewProductos;
    private javax.swing.JButton btnNewProveedor;
    private javax.swing.JButton btnNewVentas;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSaveCliente;
    private javax.swing.JButton btnSaveProductos;
    private javax.swing.JButton btnSaveProveedor;
    private javax.swing.JButton btnSaveVentas;
    private javax.swing.JButton btnTarjetaVentas;
    private javax.swing.JComboBox<String> cbxProveedor;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblClienteTitulo;
    private javax.swing.JLabel lblClienteTitulo1;
    private javax.swing.JLabel lblClienteTitulo2;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblInicioTitulo1;
    private javax.swing.JLabel lblMenuPrincipal;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblProveedores;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JPanel pnlClientes;
    private javax.swing.JPanel pnlDatosProveedor;
    private javax.swing.JPanel pnlInfoClientes;
    private javax.swing.JPanel pnlInfoProducto;
    private javax.swing.JPanel pnlInfoVentas;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlLocal;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMenuPrincipal;
    private javax.swing.JPanel pnlProductos;
    private javax.swing.JPanel pnlProveedores;
    private javax.swing.JPanel pnlVentas;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tablaProveedores;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JTextField txtCantProductos;
    private javax.swing.JTextField txtCantVentas;
    private javax.swing.JTextField txtCodVentas;
    private javax.swing.JTextField txtCorreoCliente;
    private javax.swing.JTextField txtCorreoProveedor;
    private javax.swing.JTextField txtDescVentas;
    private javax.swing.JTextField txtDireCliente;
    private javax.swing.JTextField txtDireProveedor;
    private javax.swing.JTextField txtDocCliente;
    private javax.swing.JTextField txtIdProductos;
    private javax.swing.JTextField txtNITProveedor;
    private javax.swing.JTextField txtNomCliente;
    private javax.swing.JTextField txtNomProductos;
    private javax.swing.JTextField txtNomVentas;
    private javax.swing.JTextField txtPrecioProductos;
    private javax.swing.JTextField txtPrecioVentas;
    private javax.swing.JTextField txtRazonSocProveedor;
    private javax.swing.JTextField txtTelCliente;
    private javax.swing.JTextField txtTelProveedor;
    private javax.swing.JTextField txtTotalaPagar;
    // End of variables declaration//GEN-END:variables

    private void LimpiarClientes() {

        txtDocCliente.setText(null);
        txtNomCliente.setText(null);
        txtDireCliente.setText(null);
        txtTelCliente.setText(null);
        txtCorreoCliente.setText(null);
        txtDocCliente.requestFocus();

    }

    private void LimpiarProveedores() {

        txtNITProveedor.setText("");
        txtRazonSocProveedor.setText(null);
        txtDireProveedor.setText("");
        txtTelProveedor.setText(null);
        txtCorreoProveedor.setText("");
        txtNITProveedor.requestFocus();

    }

    private void LimpiarProductos() {

        txtIdProductos.setText(null);
        txtNomProductos.setText(null);
        txtPrecioProductos.setText(null);
        txtCantProductos.setText(null);
        txtIdProductos.requestFocus();

    }

    private void RegistrarVentas() {

        String Cliente = txtNomCliente.getText();
        String Vendedor = lblClienteTitulo2.getText();

    }

}
