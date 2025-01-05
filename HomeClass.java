package com.louis.ui;

import com.louis.bean.Clothes;
import com.louis.bean.Order;
import com.louis.bean.OrderItem;
import com.louis.service.ClothesService;
import com.louis.service.OrderService;
import com.louis.service.impl.ClothesServiceImpl;
import com.louis.service.impl.OrderServiceImpl;
import com.louis.utils.BusinessException;
import com.louis.utils.ConsoleTable;
import com.louis.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class HomeClass extends BaseClass{

    private OrderService orderService = new OrderServiceImpl();
    private ClothesService clothesService = new ClothesServiceImpl();

    public void show(){
        showProducts();
        println("welcome:"+curruser.getUsername());
        boolean flag = true;
        while (flag){
            println(getString("home.function"));
            println(getString("info.select"));
            String select = input.nextLine();
            switch (select){
                case "1": //查询全部订单
                    findList();
                    flag = false;
                    break;
                case "2": //查找订单
                    findOrderById();
                    flag = false;
                    break;
                case "3": //购买
                    try{
                        buyProducts();
                        flag = false;
                        break;
                    }catch(BusinessException e){
                        println(e.getMessage());
                    }
                    break;
                case "0": //退出
                    flag = false;
                    System.exit(0);
                    break;
                default:
                    println(getString("input.error"));
                    break;
            }
        }
    }

    /**
     * 购买商品
     * @throws BusinessException
     */
    private void buyProducts() throws BusinessException {
        //生成订单
        boolean flag = true;
        int count = 1;
        float sum = 0.0f;//订单总金额
        Order order = new Order();//生成的订单
        while (flag){
            println(getString("product.input.id"));
            String id = input.nextLine();
            println(getString("product.input.shoppingNum"));
            String shoppingNum = input.nextLine();
            OrderItem orderItem = new OrderItem();
            Clothes clothes = clothesService.findById(id);
            int num = Integer.parseInt(shoppingNum);
            if (num>clothes.getNum()){
                throw new BusinessException("product.num.error");
            }
            //一条订单明细
            clothes.setNum(clothes.getNum()-num);//减库存
            orderItem.setClothes(clothes);
            orderItem.setShoppingNum(num);
            orderItem.setSum(clothes.getPrice()*num);
            sum += orderItem.getSum();
            orderItem.setItemId(count++);
            order.getOrderItemList().add(orderItem);
            println(getString("product.buy.continue"));
            String isbuy = input.nextLine();
            switch (isbuy){
                case "1":
                    flag = true;
                    break;
                case "2":
                    flag = false;
                    break;
                default:
                    flag = false;
                    break;
            }
        }
        order.setCreateDate(DateUtils.toDate(new Date()));
        order.setUserId(curruser.getId());
        order.setSum(sum);
        order.setOrderId(orderService.list().size()+1);
        orderService.buyProduct(order);
        clothesService.update();
        showProducts();
    }

    private void findOrderById() {

    }

    private void findList() {

    }

    private void showProducts(){
        ClothesService clothesService = new ClothesServiceImpl();
        List<Clothes> list = clothesService.list();
        ConsoleTable t = new ConsoleTable(8,true);
        t.appendRow();
        t.appendColumn("id")
                .appendColumn("brand")
                .appendColumn("style")
                .appendColumn("color")
                .appendColumn("size")
                .appendColumn("num")
                .appendColumn("price")
                .appendColumn("description");
        for (Clothes c: list){
            t.appendRow();
            t.appendColumn(c.getId())
                    .appendColumn(c.getBrand())
                    .appendColumn(c.getStyle())
                    .appendColumn(c.getColor())
                    .appendColumn(c.getSize())
                    .appendColumn(c.getNum())
                    .appendColumn(c.getPrice())
                    .appendColumn(c.getDescription());
        }
        println(t.toString());
    }
}
