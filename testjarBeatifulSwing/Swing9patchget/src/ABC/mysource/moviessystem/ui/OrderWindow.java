package ABC.mysource.moviessystem.ui;


import ABC.mysource.moviessystem.database.Moviedao;
import ABC.mysource.moviessystem.database.OrderDao;
import ABC.mysource.moviessystem.database.ShowDao;
import ABC.mysource.moviessystem.take.Movie;
import ABC.mysource.moviessystem.take.Order;
import ABC.mysource.moviessystem.take.Show;
import ABC.mysource.moviessystem.take.Ticket;
import ABC.mysource.moviessystem.util.CheckHandler;
import ABC.mysource.moviessystem.util.Constant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

//开始订票
public class OrderWindow extends JFrame {
    //属性
    private JTable showTable;
    private JLabel seatMatrix;
    private JLabel ticketTable;
    private Container contentPane;
    private JPanel mainPane;
    private JPanel bottomPane;

    private JTextField seatRowVal;
    private JTextField seatColVal;
    private JTextField userNameVal;
    private JTextField userPhoneVal;

    private List<Ticket> ticketList;
    private Ticket ticketTmp;
    //构造电影票的List
   public OrderWindow(){
        ticketList = new ArrayList<Ticket>();
        ticketTmp = new Ticket();
         initUI();
    }


    //生成用户界面
    public void initUI(){
        setTitle("在线订票系统前台");
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        //页面上半部分
        mainPane =new JPanel();
        mainPane.setBorder(new EmptyBorder(10,10,10,10));

        //（1）展示放映场次表格，选择后显示座位
        final JPanel showPane = new JPanel();
        //设置面板大小
        showPane.setPreferredSize(new Dimension(300,350));
//        pack();
        final BorderLayout bdLayout  =new BorderLayout();
        bdLayout.setVgap(5);//设置垂直间距
        showPane.setLayout(bdLayout);           //bdLayout
        final JScrollPane scrollPane = new JScrollPane();//活动滚条
        showPane.add(scrollPane);

        showTable = new JTable();//显示表格
        JTextField tf = new JTextField();
        tf.setEnabled(false);//设置文本域不可编辑

        DefaultCellEditor editor = new DefaultCellEditor(tf);//文本字段编辑器
        showTable.setDefaultEditor(Object.class,editor);//设置表格无法编辑
        showTable.setRowSelectionAllowed(true);//添加滚动条

        scrollPane.setViewportView(showTable);//将表格添加到滑动条面板上
        paintShowTable("","");//传入空值，得到全部
        showTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                //显示座位信息
                paintSeatMatrix((int) showTable.getValueAt(showTable.getSelectedRow(),0),"");
            }
        });
        //显示面板添加到主面板
        mainPane.add(showPane,BorderLayout.WEST);
        //展示场次座位，用户选择后的票信息会添加到订单
        seatMatrix = new JLabel();

        seatMatrix.setPreferredSize(new Dimension(200,350));
        seatMatrix.setVerticalAlignment(SwingConstants.TOP);
        paintSeatMatrix(0,"");

        mainPane.add(seatMatrix,BorderLayout.CENTER);
        seatMatrix.setBackground(Color.white);
        seatMatrix.setOpaque(true);//setOpaque

        ticketTable = new JLabel();
        ticketTable.setPreferredSize(new Dimension(350,350));
        ticketTable.setBorder(new EmptyBorder(0,20,0,0));
        ticketTable.setVerticalAlignment(SwingConstants.TOP);
        paintTicketTable();
        mainPane.add(ticketTable,BorderLayout.EAST);

        //设置主要功能区域（页面下半部分）
        bottomPane = new JPanel();
        bottomPane.setLayout(new BorderLayout());
        bottomPane.setBorder(new EmptyBorder(10,10,10,10));

        //选择座位功能
        JPanel selectPane = new JPanel();
        selectPane.setLayout(new BorderLayout());
        selectPane.setPreferredSize(new Dimension(300,100));

        JLabel selectDesc = new JLabel("输入行与列");
        selectPane.add(selectDesc,BorderLayout.NORTH);
        JPanel inputPane = new JPanel();
        inputPane.setLayout(new GridLayout(1,4));
        JLabel seatRowName = new JLabel("行数");
        JLabel seatColName = new JLabel("列数");

        seatRowName.setHorizontalAlignment(SwingConstants.RIGHT);
        seatColName.setHorizontalAlignment(SwingConstants.RIGHT);
        seatRowVal = new JTextField("行数");//输入文本框
        seatColVal = new JTextField("列数");

        inputPane.add(seatRowName);
        inputPane.add(seatRowVal);

        inputPane.add(seatColName);
        inputPane.add(seatColVal);




        selectPane.add(inputPane,BorderLayout.CENTER);
        JButton selectBtn = new JButton("选定座位");
        selectBtn.setPreferredSize(new Dimension(300,50));
        selectBtn.addActionListener(new ActionListener() {//按钮选定后提交
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSelectSeatActionPerforned(e);
            }
        });


        selectPane.add(selectBtn,BorderLayout.SOUTH);//添加设置按钮，布局？
        bottomPane.add(selectPane,BorderLayout.WEST);

        //订单提交区域
        JPanel orderPane  = new JPanel();
        orderPane.setLayout(new BorderLayout());
        orderPane.setPreferredSize(new Dimension(300,100));

        JLabel orderDesc = new JLabel("请输入个人信息:");
        orderPane.add(orderDesc,BorderLayout.NORTH);

        //用户信息面板
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1,4));

        JLabel userName = new JLabel("姓名");
        JLabel userPhone= new JLabel("手机号");

        userName.setHorizontalAlignment(SwingConstants.RIGHT);
        userPhone.setHorizontalAlignment(SwingConstants.RIGHT);
        userNameVal = new JTextField();
        userPhoneVal= new JTextField();

        inputPanel.add(userName);
        inputPanel.add(userNameVal);
        inputPanel.add(userPhone);
        inputPanel.add(userPhoneVal);


        orderPane.add(inputPanel,BorderLayout.CENTER);
        JButton placeBtn = new JButton("提交订单");
        placeBtn.setPreferredSize(new Dimension(300,50));
        placeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPlaceOrderActionPerformed(e);
            }
        });

        orderPane.add(placeBtn,BorderLayout.SOUTH);
        bottomPane.add(orderPane,BorderLayout.EAST);

        contentPane.add(mainPane,BorderLayout.NORTH);
        contentPane.add(bottomPane,BorderLayout.SOUTH);

        setSize(900,600);
        setResizable(false);

        setLocationRelativeTo(getOwner());
        setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();//不可见
            }//复写
        });//关闭程序

    }


    //选完座位后的处理
    private void btnSelectSeatActionPerforned(ActionEvent e){
        if (ticketTmp.getShow() == 0){//未选择场次
            JOptionPane.showMessageDialog(this,"请先选择电影");
            return;
        }
        Ticket ticket = new Ticket();
        try{
            ticket.setMovie(ticketTmp.getMovie());
            ticket.setShow(ticketTmp.getShow());
            ticket.setTime(ticketTmp.getTime());
            ticket.setPrice(ticketTmp.getPrice());
//            ticket.setSeatRow(ticketTmp.getSeatRow());
//            ticket.setSeatColumn(ticketTmp.getSeatColumn());
            ticket.setSeatColumn(Integer.parseInt(seatColVal.getText()));//从输入中获取  0< col <=9
            ticket.setSeatColumn(Integer.parseInt(seatRowVal.getText()));//0< row<=12

        }catch (NumberFormatException ex){//输入
            JOptionPane.showMessageDialog(this,"输入为空或格式不对，重新输入");
//            JOptionPane.showMessageDialog(this, "alert", "alert", JOptionPane.ERROR_MESSAGE);
        }

        //座位超出放映厅范围
        if(ticket.getSeatRow()<1 || ticket.getSeatRow()>Constant.HALL_ROW_NUM ||
                ticket.getSeatColumn()<1 || ticket.getSeatColumn()>Constant.HALL_COLUMN_NUM){
            JOptionPane.showMessageDialog(this,"输入的座位位置有误");
            return;
        }
        boolean paintSuccess = paintSeatMatrix(ticket.getShow(),ticket.getSeatRow()+","+ticket.getSeatColumn());
        if (!paintSuccess){
            JOptionPane.showMessageDialog(this,"无法预定，重新选择");
            return;
        }

        ticketList.add(ticket);
        paintTicketTable();

    }



    //显示当前场次
    private void paintShowTable(String field, String value){
        DefaultTableModel model = new DefaultTableModel();
        showTable.setModel(model);
        Object[][] tbData = null;
        int  i = 0;
        String[] labels = {"放映场次","电影名称","放映时间","票价/元"};
        //查询数据库 中所有电影放映信息
        List<Show> shows   = ShowDao.getShows(field,value);
        tbData = new Object[shows.size()][labels.length];
        for (Show show:shows){
            Movie movie = Moviedao.getMovie(show.getMid());//利用show中mid找电影
            if (movie == null){
                continue;
            }//查不到电影，不显示,下一个，防止管理员输入错误
            tbData[i][0]=show.getId();
            tbData[i][1]=movie.getName();
            tbData[i][2]=show.getTime();
            tbData[i][3]=show.getPrice();
            i++;
        }
        model.setDataVector(tbData,labels);

    }



    //展示订单中电影票列表
    private void paintTicketTable(){
       String ticketHtml = "";
       double priceTotal = 0;//总价
       ticketHtml += "<table width = 320 border =1><tr>";
       for (String label : Constant.ticketLables){
           ticketHtml+="<th>"+label+"</th>";
       }//标签名称
        int i = 0;//序号
        for (Ticket ticket: ticketList){
            ticketHtml+="<tr><td>"+(i+1)+"</td>";
            ticketHtml+="<td>"+ticket.getMovie()+"</td>";
            ticketHtml+="<td>"+ticket.getTime()+"</td>";
            ticketHtml+="<td>"+ticket.getPrice()+"</td>";
            ticketHtml+="<td>"+ticket.getSeatRow()+"行"+ticket.getSeatColumn()+"列</td><tr>";
            priceTotal += ticket.getPrice();
            i++;
        }
        ticketHtml += "<tr><td colspan = 5>总计： "+priceTotal+"元</td><tr></table>";
        String title = "<p>你的当前订单("+(i>0?("包含"+i+"张票"):"订单为空")+")</p>";
        ticketHtml  = "<html>"+title+ticketHtml+"</html>";
        ticketTable.setText(ticketHtml);
    }

    //显示放映厅座位图
    private boolean paintSeatMatrix(int showId,String checkSeat){
        String usedSeats = "";
        String seatHtml  = "";
        Show show = ShowDao.getShow(showId);
        if (show != null){//选好了场次
            usedSeats = show.getSeatsUsed();
            ticketTmp.setMovie(Moviedao.getMovie(show.getMid()).getName());
            ticketTmp.setPrice(show.getPrice());
            ticketTmp.setTime(show.getTime());
            ticketTmp.setShow(show.getId());
            seatHtml += "<p>该场安排在<font color=red>"+show.getHall()
                    +"</font>号放映厅，座位情况如下（X为已选，O为未选）：</p>";
            for (Ticket t : ticketList){
                if (t.getShow() == showId){
                    usedSeats += " "+t.getSeatRow()+","+t.getSeatColumn();
                }

            }//座位的值

        }else{
            seatHtml += "<p>请选择电影，座位情况如下（X为已选，O为未选）：</p>";

        }//是否选取场次

        usedSeats = " "+usedSeats.trim()+" ";
        if (checkSeat.length()>0&&usedSeats.indexOf(" "+checkSeat+" ")>=0){
            return false;//选择的座位未被占用
        }else if(checkSeat.length()>0) {
            usedSeats += checkSeat+" ";
        }

        //打印所有列的标记
        seatHtml +="<table><tr><th></th>";

        for(int j =0;j<Constant.HALL_COLUMN_NUM;j++){
            seatHtml+="<th>"+(j+1)+"</th>";
        }
        seatHtml += "</tr>";

        //循环打印座位图
        String curSeat;
        for (int i=0;i<Constant.HALL_ROW_NUM;i++){
            for (int j=0;j<Constant.HALL_COLUMN_NUM;j++){
                if(j==0){
                    seatHtml+="<tr><th>"+(i+1)+"</th>";
                }

                curSeat = " "+(i+1)+","+(j+1)+" ";
                //位置是否预定
                if(usedSeats.indexOf(curSeat)>=0){
                    seatHtml+="<td><font color = red>X</font></td>";
                }else {
                    seatHtml+="<td>O<td>";
                }//打印OX
                if (j==Constant.HALL_COLUMN_NUM-1){
                    seatHtml+="</tr>";
                }//每行结尾结束

            }
        }//列的循环

        seatHtml+="</table>";
        seatHtml+="<html>"+seatHtml+"</html>";
        seatMatrix.setText(seatHtml);



       return true;
    }


    //提交订单后的处理：
    private void btnPlaceOrderActionPerformed(ActionEvent e){
       String userName = userNameVal.getText().trim();
       String userPhone = userPhoneVal.getText().trim();

       //判断订单是否为0
        if (ticketList.size()==0){
            JOptionPane.showMessageDialog(this,"你当前订单为空");
            return;
        }
        //判断姓名||手机号是否为空
        if(userName.length() == 0 ||  userPhone.length() == 0){
            JOptionPane.showMessageDialog(this,"姓名或手机号未输入");
            return;
        }
        //判断姓名是否为中文
        if (CheckHandler.containsChar(userName) || CheckHandler.containsDigit(userName)){
            JOptionPane.showMessageDialog(this,"输入姓名非中文，重新输入");
            return;
        }

        //手机号码格式
        if(CheckHandler.isValidMobile(userPhone)){
            JOptionPane.showMessageDialog(this,"手机号码格式错误:11位，1【34578】+");
            return;
        }

        //创建订单
        Order order = new Order();
        order.setName(userName);
        order.setPhone(userPhone);
        String data="";
        String seat="";
        //记录订单数据，数据用竖线隔开
        //不同票的数据用分号隔开
        for (Ticket t : ticketList){
            seat = t.getSeatRow()+","+t.getSeatColumn();
            if (data.length()>0){
                data+=";";  //与上一个数据分隔
            }
            data += t.getShow()+" "+seat+"|"+t.getMovie()+"|"+t.getTime();
            Show show = ShowDao.getShow(t.getShow());
            String seatsUsed = show.getSeatsUsed()+" "+seat;
            show.setSeatsUsed(seatsUsed.trim());
            ShowDao.updateShow(show);
        }
        order.setData(data);
        boolean addSuccess = OrderDao.addOrder(order);
        JOptionPane.showMessageDialog(this,addSuccess? "订票成功，订单区将清空" : "下单失败");
            //完成提交
        if(addSuccess){
            ticketList = new ArrayList<Ticket>();
            paintTicketTable();
            seatRowVal.setText("");
            seatColVal.setText("");
            userNameVal.setText("");
            userPhoneVal.setText("");
        }//清空订单界面数据，方便用户继续订票

    }




}//类
