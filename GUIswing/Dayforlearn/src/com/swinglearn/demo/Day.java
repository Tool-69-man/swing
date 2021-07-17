package com.swinglearn.demo;

import javax.swing.*;
//模板

public class Day {
    public static void main(String[] args) {

        try {
            new JFUI();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        JFrame jf = new JFrame("");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jf.setSize(500,500);
        // 第 1 个 JPanel, 使用默认的浮动布局
        JPanel panel01 = new JPanel();

        jf.add(panel01);
        jf.setContentPane(panel01);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }


    /**
     * 参数说明:
         view: 需要滚动显示的视图组件
          vsbPolicy: 垂直滚动条的显示策略
     *     hsbPolicy: 水平滚动条的显示策略
     /
//    JScrollPane()
//    JScrollPane(Component view)
//
//    JScrollPane(Component view, int vsbPolicy, int hsbPolicy)
//
//    JScrollPane(int vsbPolicy, int hsbPolicy)
//
//    /*
//     * 垂直滚动条（vsbPolicy）
//     */
//    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED    // 需要时显示（默认）
//    ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER        // 从不显示
//    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS       // 总是显示
//
//    /*
//     * 水平滚动条（hsbPolicy）
//     */
//    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED  // 需要时显示（默认）
//    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER      // 从不显示
//    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS     // 总是显示
//
//
//    // 设置滚动显示视图内容组件
//    void setViewportView(Component view)
//
//    // 设置垂直滚动条的显示策略
//    void setVerticalScrollBarPolicy(int policy)
//
//    // 设置水平滚动条的显示策略
//    void setHorizontalScrollBarPolicy(int policy)
//
//    // 是否响应鼠标滚动事件，默认响应
//    void setWheelScrollingEnabled(boolean handleWheel)
//
//    // 创建文本区域组件
//    JTextArea textArea = new JTextArea();
//        textArea.setLineWrap(true);                         // 自动换行
//        textArea.setFont(new Font(null, Font.PLAIN, 18));   // 设置字体
//
//    // 创建滚动面板, 指定滚动显示的视图组件(textArea), 垂直滚动条一直显示, 水平滚动条从不显示
//    JScrollPane scrollPane = new JScrollPane(
//            textArea,
//            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
//            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
//    );
//
//
//    /**
//     * 参数说明:
//     *     orientation: 分隔的方向，取值 JSplitPane.HORIZONTAL_SPLIT（水平左右分隔）
//     *                  或 JSplitPane.VERTICAL_SPLIT（垂直上下分隔），默认水平左右分隔。
//     *
//     *     continuousLayout: 拖动分隔条时，是否连续重绘组件，如果为flase，则拖动分隔条停止后才重绘组件。
//     *
//     *     leftComponent: 左边/上面 显示的组件
//     *
//     *     rightComponent: 右边/下面 显示的组件
//     */
//    JSplitPane()
//
//    JSplitPane(int orientation)
//
//    JSplitPane(int orientation, boolean continuousLayout)
//
//    JSplitPane(int orientation, boolean continuousLayout, Component leftComponent, Component rightComponent)
//
//    JSplitPane(int orientation, Component leftComponent, Component rightComponent)
//
//    // 设置分隔的方向，水平(左右) 或 垂直(上下) 分隔
//    void setOrientation(int orientation)
//
//    // 设置 左边/上面 显示的组件（下面两个方法完全一致）
//    void setLeftComponent(Component comp)
//    void setTopComponent(Component comp)
//
//    // 设置 左边/下面 显示的组件（下面两个方法完全一致）
//    void setRightComponent(Component comp)
//    void setBottomComponent(Component comp)
//
//    // 设置 拖动分隔条 时是否 连续重绘 组件
//    void setContinuousLayout(boolean continuousLayout)
//
//    // 分隔条上是否显示快速 折叠/展开 两边组件的小按钮
//    void setOneTouchExpandable(boolean newValue)
//
//    // 设置分隔条的大小（宽度）
//    void setDividerSize(int newSize)
//
//    // 设置分隔条的位置，相对于 左边/顶部 的像素长度
//    void setDividerLocation(int location)
//
//    // 设置分隔条的位置，相对于 宽度/高度 的比例 [0.0 ~ 1.0]（该方法必须要先确保 JSplitPane 已经有宽高值，否则无效）
//    void setDividerLocation(double proportionalLocation)
//
//
//
//import javax.swing.*;
//
//    public class Main {
//
//        public static void main(String[] args) {
//            JFrame jf = new JFrame("测试窗口");
//            jf.setSize(300, 300);
//            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//            jf.setLocationRelativeTo(null);
//
//            // 创建分隔面板
//            JSplitPane splitPane = new JSplitPane();
//
//            // 设置左右两边显示的组件
//            splitPane.setLeftComponent(new JButton("左边按钮"));
//            splitPane.setRightComponent(new JButton("右边按钮"));
//
//            // 分隔条上显示快速 折叠/展开 两边组件的小按钮
//            splitPane.setOneTouchExpandable(true);
//
//            // 拖动分隔条时连续重绘组件
//            splitPane.setContinuousLayout(true);
//
//            // 设置分隔条的初始位置
//            splitPane.setDividerLocation(150);
//
//            // 把分隔面板作为内容面板添加到窗口并显示
//            jf.setContentPane(splitPane);
//            jf.setVisible(true);
//        }
//
//    }
//
//
//    /**
//     * 参事说明:
//     *     tabPlacement: 选项卡标题的位置, 值为 JTabbedPane.TOP、JTabbedPane.BOTTOM、
//     *                   JTabbedPane.LEFT 或 JTabbedPane.RIGHT, 默认为 TOP
//     *
//     *     tabLayoutPolicy: 选项卡位置不能放入所有的选项卡时，放置选项卡的策略，
//     *                      值为 JTabbedPane.WRAP_TAB_LAYOUT 或 JTabbedPane.SCROLL_TAB_LAYOUT
//     */
//    JTabbedPane()
//
//    JTabbedPane(int tabPlacement)
//
//    JTabbedPane(int tabPlacement, int tabLayoutPolicy)
//
//
//
//
//    /**
//     * 参数说明:
//     *     title: 选项卡的标题
//     *     icon: 选项卡的图标
//     *     tip: 当鼠标移到该选项卡时，悬浮提示的文本
//     *     component: 选中该选项卡时显示的内容组件
//     */
//    void addTab(String title, Component component)
//
//    void addTab(String title, Icon icon, Component component)
//
//    void addTab(String title, Icon icon, Component component, String tip)
//
//    /**
//     * 在指定索引位置插入一个选项卡
//     */
//    void insertTab(String title, Icon icon, Component component, String tip, int index)
//
//
//    // 移除指定位置的选项（下面两个方法完全一致）
//    void removeTabAt(int index)
//    void remove(int index)
//
//    // 移除指定内容控件的选项卡
//    void remove(Component component)
//
//    // 移除所有选项卡
//    void removeAll()
//
//    // 设置当前选中的选项卡
//    void setSelectedIndex(int index)
//
//    // 获取当前选中的选项卡索引
//    int getSelectedIndex()
//
//    // 获取当前选中的选项卡对应的内容组件
//    Component getSelectedComponent()
//
//    // 设置 index 位置的选项卡的标题
//    void setTitleAt(int index, String title)
//
//    // 设置 index 位置的选项卡的图标
//    void setIconAt(int index, Icon icon)
//
//    // 设置 index 位置的选项卡是否可用
//    void setEnabledAt(int index, boolean enabled)
//
//    // 将 index 位置的内容组件设置为 component
//    void setComponentAt(int index, Component component)
//
//    // 获取选项卡的数量
//    int getTabCount()
//
//    /**
//     * 自定义选项卡标题位置的组件, 这里的 titleComponent 将放到选项卡标题位置。
//     * 应用场景: 例如, 在选项卡标题位置添加一个关闭按钮, 点击按钮移除选项卡。
//     */
//    void setTabComponentAt(int index, Component titleComponent)
//
//
//    // 添加选项卡选中状态改变的监听器
//    void addChangeListener(ChangeListener l)
//
//
//import javax.swing.*;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//import java.awt.*;
//
//    public class Main {
//
//        public static void main(String[] args) {
//            JFrame jf = new JFrame("测试窗口");
//            jf.setSize(300, 300);
//            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//            jf.setLocationRelativeTo(null);
//
//            // 创建选项卡面板
//            final JTabbedPane tabbedPane = new JTabbedPane();
//
//
//            // 创建第 1 个选项卡（选项卡只包含 标题）
//            tabbedPane.addTab("Tab01", createTextPanel("TAB 01"));
//
//            // 创建第 2 个选项卡（选项卡包含 标题 和 图标）
//            tabbedPane.addTab("Tab02", new ImageIcon("bb.jpg"), createTextPanel("TAB 02"));
//
//            // 创建第 3 个选项卡（选项卡包含 标题、图标 和 tip提示）
//            tabbedPane.addTab("Tab03", new ImageIcon("bb.jpg"), createTextPanel("TAB 03"), "This is a tab.");
//
//
//            // 添加选项卡选中状态改变的监听器
//            tabbedPane.addChangeListener(new ChangeListener() {
//                @Override
//                public void stateChanged(ChangeEvent e) {
//                    System.out.println("当前选中的选项卡: " + tabbedPane.getSelectedIndex());
//                }
//            });
//
//            // 设置默认选中的选项卡
//            tabbedPane.setSelectedIndex(1);
//
//            jf.setContentPane(tabbedPane);
//            jf.setVisible(true);
//        }
//
//        /**
//         * 创建一个面板，面板中心显示一个标签，用于表示某个选项卡需要显示的内容
//         */
//        private static JComponent createTextPanel(String text) {
//            // 创建面板, 使用一个 1 行 1 列的网格布局（为了让标签的宽高自动撑满面板）
//            JPanel panel = new JPanel(new GridLayout(1, 1));
//
//            // 创建标签
//            JLabel label = new JLabel(text);
//            label.setFont(new Font(null, Font.PLAIN, 50));
//            label.setHorizontalAlignment(SwingConstants.CENTER);
//
//            // 添加标签到面板
//            panel.add(label);
//
//            return panel;
//        }
//
//    }
//
//
//    ImageIcon imageIcon = new ImageIcon("duke.gif");    // Icon由图片文件形成
//    Image image = imageIcon.getImage();                         // 但这个图片太大不适合做Icon
//    //    为把它缩小点，先要取出这个Icon的image ,然后缩放到合适的大小
//    Image smallImage = image.getScaledInstance(30,20,Image.SCALE_FAST);
//    //    再由修改后的Image来生成合适的Icon
//    ImageIcon smallIcon = new ImageIcon(smallImage);
//    //   最后设置它为按钮的图片
//    JButton iconButton = new JButton(smallIcon);


//    showMessageDialog	消息对话框，向用户展示一个消息，没有返回值。
//    showConfirmDialog	确认对话框，询问一个问题是否执行。
//    showInputDialog	输入对话框，要求用户提供某些输入。
//    showOptionDialog	选项对话框，上述三项的大统一，自定义按钮文本，询问用户需要点击哪个按钮。

// 创建一个层及面部
//    JLayeredPane()
//
//    /**
//     * 添加组件到指定的层（默认放到层内最底部），参数说明:
//     *     comp: 待添加的组件
//     *     layer: 所在的层, 层数是int类型, 由于该方法与另一个 add(Component, int) 方法类似, 直接使用会有冲突, 所以使
//     *            用该方法传递 layer 参数时, 必须使用 Integer 类型来明确调用的是下面 add(Component, Object) 方法。
//     */
//    void add(Component comp, Object layer)
//
//    // 添加组件到指定的层和层内的位置
//    void add(Component comp, Object layer, int position)
//
//    // 设置组件所在层（默认放到层内最底部）
//    void setLayer(Component c, int layer)
//
//    // 设置组件所在层，以及在层内的位置
//    void setLayer(Component c, int layer, int position)
//
//    // 移动组件到其所在层的最顶部位置
//    void moveToFront(Component c)
//
//    // 移动组件到其所在层的最底部位置
//    void moveToBack(Component c)
//
//    // 设置组件在其所在层的位置，其中 position 取值范围为: [-1, n - 1]，n 表示层内组件数量，其中 -1 表示最底，0 表示最顶
//    void setPosition(Component c, int position)
//
//
//
///**
// * 参数说明:
// *     text: 菜单显示的文本
// *     icon: 菜单显示的图标
// */
//JMenuItem()
//
//JMenuItem(String text)
//
//JMenuItem(Icon icon)
//
//JMenuItem(String text, Icon icon)

//
//
//    // 设置菜单显示的文本
//    void setText(String text)
//
//    // 设置菜单显示的图标
//    void setIcon(Icon defaultIcon)
//
//    // 设置菜单的键盘助记符
//    void setMnemonic(int mnemonic)
//    // 设置修改键，使用键盘快捷键直接触发菜单项的动作
//    void setAccelerator(KeyStroke keyStroke)
//    /*
//     * 例如按下 ALT+N 键触发菜单项动作:
//     *     menuItem.setMnemonic(KeyEvent.VK_N);
//     *     menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
//     */
//
//    // 添加菜单被点击的监听器
//    void addActionListener(ActionListener l)
//
//    // 绑定菜单项的动作命令名称，如果所有菜单项使用同一个监听器，
//// 可以再监听器回调时通过命令名称区别是哪个菜单项触发的动作。
//    void setActionCommand(String actionCommand)
// 设置 复选框/单选按钮 是否选中
//    void setSelected(boolean b)
//
//    // 判断 复选框/单选按钮 是否选中
//    boolean isSelected()
//
//    // 添加 复选框/单选按钮 状态被改变的监听器
//    void addChangeListener(ChangeListener l)

// 添加 子菜单 到 JMenu 中
//    JMenuItem add(JMenuItem menuItem)
//
//    // 添加一个子菜单分割线
//    void addSeparator()

//
//    package com.xiets.swing;
//
//import javax.swing.*;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//
//    public class Main {
//
//        public static void main(String[] args) throws Exception {
//            final JFrame jf = new JFrame("测试窗口");
//            jf.setSize(300, 300);
//            jf.setLocationRelativeTo(null);
//            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//            /*
//             * 创建一个菜单栏
//             */
//            JMenuBar menuBar = new JMenuBar();
//
//            /*
//             * 创建一级菜单
//             */
//            JMenu fileMenu = new JMenu("文件");
//            JMenu editMenu = new JMenu("编辑");
//            JMenu viewMenu = new JMenu("视图");
//            JMenu aboutMenu = new JMenu("关于");
//            // 一级菜单添加到菜单栏
//            menuBar.add(fileMenu);
//            menuBar.add(editMenu);
//            menuBar.add(viewMenu);
//            menuBar.add(aboutMenu);
//
//            /*
//             * 创建 "文件" 一级菜单的子菜单
//             */
//            JMenuItem newMenuItem = new JMenuItem("新建");
//            JMenuItem openMenuItem = new JMenuItem("打开");
//            JMenuItem exitMenuItem = new JMenuItem("退出");
//            // 子菜单添加到一级菜单
//            fileMenu.add(newMenuItem);
//            fileMenu.add(openMenuItem);
//            fileMenu.addSeparator();       // 添加一条分割线
//            fileMenu.add(exitMenuItem);
//
//            /*
//             * 创建 "编辑" 一级菜单的子菜单
//             */
//            JMenuItem copyMenuItem = new JMenuItem("复制");
//            JMenuItem pasteMenuItem = new JMenuItem("粘贴");
//            // 子菜单添加到一级菜单
//            editMenu.add(copyMenuItem);
//            editMenu.add(pasteMenuItem);
//
//            /*
//             * 创建 "视图" 一级菜单的子菜单
//             */
//            final JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem("复选框子菜单");
//            final JRadioButtonMenuItem radioButtonMenuItem01 = new JRadioButtonMenuItem("单选按钮子菜单01");
//            final JRadioButtonMenuItem radioButtonMenuItem02 = new JRadioButtonMenuItem("单选按钮子菜单02");
//            // 子菜单添加到一级菜单
//            viewMenu.add(checkBoxMenuItem);
//            viewMenu.addSeparator();                // 添加一个分割线
//            viewMenu.add(radioButtonMenuItem01);
//            viewMenu.add(radioButtonMenuItem02);
//
//            // 其中两个 单选按钮子菜单，要实现单选按钮的效果，需要将它们放到一个按钮组中
//            ButtonGroup btnGroup = new ButtonGroup();
//            btnGroup.add(radioButtonMenuItem01);
//            btnGroup.add(radioButtonMenuItem02);
//
//            // 默认第一个单选按钮子菜单选中
//            radioButtonMenuItem01.setSelected(true);
//
//            /*
//             * 菜单项的点击/状态改变事件监听，事件监听可以直接设置在具体的子菜单上（这里只设置其中几个）
//             */
//            // 设置 "新建" 子菜单被点击的监听器
//            newMenuItem.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    System.out.println("新建  被点击");
//                }
//            });
//            // 设置 "打开" 子菜单被点击的监听器
//            openMenuItem.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    System.out.println("打开  被点击");
//                }
//            });
//            // 设置 "退出" 子菜单被点击的监听器
//            exitMenuItem.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    System.out.println("退出  被点击");
//                }
//            });
//
//            // 设置 复选框子菜单 状态改变 监听器
//            checkBoxMenuItem.addChangeListener(new ChangeListener() {
//                @Override
//                public void stateChanged(ChangeEvent e) {
//                    System.out.println("复选框是否被选中: " + checkBoxMenuItem.isSelected());
//                }
//            });
//
//            // 设置 单选按钮子菜单 状态改变 监听器
//            radioButtonMenuItem01.addChangeListener(new ChangeListener() {
//                @Override
//                public void stateChanged(ChangeEvent e) {
//                    System.out.println("单选按钮01 是否被选中: " + radioButtonMenuItem01.isSelected());
//                }
//            });
//
//            /*
//             * 最后 把菜单栏设置到窗口
//             */
//            jf.setJMenuBar(menuBar);
//
//            jf.setVisible(true);
//        }
//
//    }




//    /**
//     * 参数说明:
//     *     name:
//     *         工具栏名称，悬浮显示时为悬浮窗口的标题。
//     *
//     *     orientation:
//     *         工具栏的方向，值为 SwingConstants.HORIZONTAL 或 SwingConstants.VERTICAL，
//     *         默认为 HORIZONTAL。
//     */
//    JToolBar()
//
//    JToolBar(String name)
//
//    JToolBar(int orientation)
//
//    JToolBar(String name, int orientation)


// 添加 工具组件 到 工具栏
//    JToolBar add(Component comp)
//
//    // 添加 分隔符组件 到 工具栏
//    void addSeparator()
//    void addSeparator(Dimension size)
//
//    // 获取工具栏中指定位置的组件（包括分隔符）
//    Component getComponentAtIndex(int index)
//
//    // 设置工具栏是否可拖动
//    void setFloatable(boolean b)
//
//    // 设置工具栏方向，值为 wingConstants.HORIZONTAL 或 SwingConstants.VERTICAL
//    void setOrientation(int o)
//
//    // 设置工具栏边缘和其内部工具组件之间的边距（内边距）
//    void setMargin(Insets m)
//
//    // 是否需要绘制边框
//    void setBorderPainted(boolean b)
//
//
//package com.xiets.swing;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//    public class Main {
//
//        public static void main(String[] args) {
//            JFrame jf = new JFrame("测试窗口");
//            jf.setSize(300, 300);
//            jf.setLocationRelativeTo(null);
//            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//            // 创建 内容面板，使用 边界布局
//            JPanel panel = new JPanel(new BorderLayout());
//
//            // 创建 一个工具栏实例
//            JToolBar toolBar = new JToolBar("测试工具栏");
//
//            // 创建 工具栏按钮
//            JButton previousBtn = new JButton(new ImageIcon("previous.png"));
//            JButton pauseBtn = new JButton(new ImageIcon("pause.png"));
//            JButton nextBtn = new JButton(new ImageIcon("next.png"));
//
//            // 添加 按钮 到 工具栏
//            toolBar.add(previousBtn);
//            toolBar.add(pauseBtn);
//            toolBar.add(nextBtn);
//
//            // 创建一个文本区域，用于输出相关信息
//            final JTextArea textArea = new JTextArea();
//            textArea.setLineWrap(true);
//
//            // 添加 按钮 的点击动作监听器，并把相关信息输入到 文本区域
//            previousBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    textArea.append("上一曲\n");
//                }
//            });
//            pauseBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    textArea.append("暂停\n");
//                }
//            });
//            nextBtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    textArea.append("下一曲\n");
//                }
//            });
//
//            // 添加 工具栏 到 内容面板 的 顶部
//            panel.add(toolBar, BorderLayout.PAGE_START);
//            // 添加 文本区域 到 内容面板 的 中间
//            panel.add(textArea, BorderLayout.CENTER);
//
//            jf.setContentPane(panel);
//            jf.setVisible(true);
//        }
//
//    }
//
//package com.xiets.swing;
//
//import javax.swing.*;
//import java.beans.PropertyVetoException;
//
//    public class Main {
//
//        public static void main(String[] args) {
//            JFrame jf = new JFrame("测试窗口");
//            jf.setSize(400, 400);
//            jf.setLocationRelativeTo(null);
//            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//            // 创建 桌面面板
//            JDesktopPane desktopPane = new JDesktopPane();
//
//            // 创建 内部窗口
//            JInternalFrame internalFrame = createInternalFrame();
//
//            // 添加 内部窗口 到 桌面面板
//            desktopPane.add(internalFrame);
//
//            // 把 桌面面板 作为 内容面板 设置到窗口并显示
//            jf.setContentPane(desktopPane);
//            jf.setVisible(true);
//
//            try {
//                // 设置 内部窗口 被选中
//                internalFrame.setSelected(true);
//            } catch (PropertyVetoException e) {
//                e.printStackTrace();
//            }
//        }
//
//        private static JInternalFrame createInternalFrame() {
//            // 创建一个内部窗口
//            JInternalFrame internalFrame = new JInternalFrame(
//                    "内部窗口",  // title
//                    true,       // resizable
//                    true,       // closable
//                    true,       // maximizable
//                    true        // iconifiable
//            );
//
//            // 设置窗口的宽高
//            internalFrame.setSize(200, 200);
//            // 设置窗口的显示位置
//            internalFrame.setLocation(50, 50);
//            // 内部窗口的关闭按钮动作默认就是销毁窗口，所有不用设置
//            // internalFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//
//            // 创建内容面板
//            JPanel panel = new JPanel();
//
//            // 添加组件到面板
//            panel.add(new JLabel("Label001"));
//            panel.add(new JButton("JButton001"));
//
//            // 设置内部窗口的内容面板
//            internalFrame.setContentPane(panel);
//
//            /*
//             * 对于内部窗口，还可以不需要手动设置内容面板，直接把窗口当做普通面板使用，
//             * 即直接设置布局，然后通过 add 添加组件，如下代码:
//             *     internalFrame.setLayout(new FlowLayout());
//             *     internalFrame.add(new JLabel("Label001"));
//             *     internalFrame.add(new JButton("JButton001"));
//             */
//
//            // 显示内部窗口
//            internalFrame.setVisible(true);
//
//            return internalFrame;
//        }
//
//    }
//
//
//
//
//package com.xiets.swing;
//
//import javax.swing.*;
//import java.beans.PropertyVetoException;
//
//public class Main {
//
//    public static void main(String[] args) {
//        JFrame jf = new JFrame("测试窗口");
//        jf.setSize(400, 400);
//        jf.setLocationRelativeTo(null);
//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        // 创建 桌面面板
//        JDesktopPane desktopPane = new JDesktopPane();
//
//        // 创建 内部窗口
//        JInternalFrame internalFrame = createInternalFrame();
//
//        // 添加 内部窗口 到 桌面面板
//        desktopPane.add(internalFrame);
//
//        // 把 桌面面板 作为 内容面板 设置到窗口并显示
//        jf.setContentPane(desktopPane);
//        jf.setVisible(true);
//
//        try {
//            // 设置 内部窗口 被选中
//            internalFrame.setSelected(true);
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static JInternalFrame createInternalFrame() {
//        // 创建一个内部窗口
//        JInternalFrame internalFrame = new JInternalFrame(
//                "内部窗口",  // title
//                true,       // resizable
//                true,       // closable
//                true,       // maximizable
//                true        // iconifiable
//        );
//
//        // 设置窗口的宽高
//        internalFrame.setSize(200, 200);
//        // 设置窗口的显示位置
//        internalFrame.setLocation(50, 50);
//        // 内部窗口的关闭按钮动作默认就是销毁窗口，所有不用设置
//        // internalFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//
//        // 创建内容面板
//        JPanel panel = new JPanel();
//
//        // 添加组件到面板
//        panel.add(new JLabel("Label001"));
//        panel.add(new JButton("JButton001"));
//
//        // 设置内部窗口的内容面板
//        internalFrame.setContentPane(panel);
//
//        /*
//         * 对于内部窗口，还可以不需要手动设置内容面板，直接把窗口当做普通面板使用，
//         * 即直接设置布局，然后通过 add 添加组件，如下代码:
//         *     internalFrame.setLayout(new FlowLayout());
//         *     internalFrame.add(new JLabel("Label001"));
//         *     internalFrame.add(new JButton("JButton001"));
//         */
//
//        // 显示内部窗口
//        internalFrame.setVisible(true);
//
//        return internalFrame;
//    }
//
//}
////
//
//// 创建一个水平箱容器
//Box hBox = Box.createHorizontalBox();
//
//// 创建一个垂直箱容器
//Box vBox = Box.createVerticalBox();
//
//
//// 创建一个 水平方向胶状 的不可见组件，用于撑满水平方向剩余的空间（如果有多个该组件，则平分剩余空间）
//Component hGlue = Box.createHorizontalGlue();
//
//// 创建一个 垂直方向胶状 的不可见组件，用于撑满垂直方向剩余的空间（如果有多个该组件，则平分剩余空间）
//Component vGlue = Box.createVerticalGlue();
//
//// 创建一个 水平和垂直方向胶状 的不可见组件，用于撑满水平和垂直方向剩余的空间（如果有多个该组件，则平分剩余空间）
//Component glue = Box.createGlue();
//
//
//
//
//// 创建一个 固定宽度 的不可见组件（用于水平箱）
//Component hStrut = Box.createHorizontalStrut(int width);
//
//// 创建一个 固定高度 的不可见组件（用于垂直箱）
//Component vStrut = Box.createVerticalStrut(int height);
//
//
//\ package com.xiets.swing;
//
//import javax.swing.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//        JFrame jf = new JFrame("测试窗口");
//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        JButton btn01 = new JButton("Button01");
//        JButton btn02 = new JButton("Button02");
//        JButton btn03 = new JButton("Button03");
//        JButton btn04 = new JButton("Button04");
//        JButton btn05 = new JButton("Button05");
//
//        // 创建第一个水平箱容器
//        Box hBox01 = Box.createHorizontalBox();
//        hBox01.add(btn01);
//        hBox01.add(btn02);
//        hBox01.add(btn03);
//
//        // 创建第二水平箱容器
//        Box hBox02 = Box.createHorizontalBox();
//        hBox02.add(btn04);
//        hBox02.add(Box.createHorizontalGlue()); // 添加一个水平方向胶状的不可见组件，撑满剩余水平空间
//        hBox02.add(btn05);
//
//        // 创建一个垂直箱容器，放置上面两个水平箱（Box组合嵌套）
//        Box vBox = Box.createVerticalBox();
//        vBox.add(hBox01);
//        vBox.add(hBox02);
//
//        // 把垂直箱容器作为内容面板设置到窗口
//        jf.setContentPane(vBox);
//
//        jf.pack();
//        jf.setLocationRelativeTo(null);
//        jf.setVisible(true);
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//asd





























































































































































































}
