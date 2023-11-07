package jz.cbq.work03.cbq;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * CBQWork03
 *
 * @author CBQ
 * @date 2023/11/8 0:47
 * @since 1.0.0
 */
public class CBQWork03 {
    static final Scanner sc = new Scanner(System.in);
    static List<Order> orderList = new ArrayList<>();
    static Integer orderId = 1;
    static List<OrderItem> orderItemList = new ArrayList<>();
    static Integer orderItemId = 1;
    static List<Book> bookList = new ArrayList<>();
    static List<Integer> bookIdList = new ArrayList<>();
    static boolean flag = true;
    static int count = 0;

    public static void main(String[] args) {

        initData(bookList, bookIdList);
        printMenu(bookList);


        while (flag) {
            System.out.println("请选择需要购买的书籍：(输入 666 前往购物车结算)");
            int select = sc.nextInt();
            if (select == 666) {
                flag = false;
                buyCar(orderItemList, orderItemId);
                orderItemId++;
                checkout(orderList, orderId - 1);
                break;
            } else if (bookIdList.contains(select)) {
                switch (select) {
                    case 1:
                        caseEach(0);
                        break;
                    case 2:
                        caseEach(1);
                        break;
                    case 3:
                        caseEach(2);
                        break;
                }
            } else {
                System.out.println("输入格式有误，请输入 （id）");
            }
        }
    }

    /**
     * each
     *
     * @param index index
     */
    private static void caseEach(int index) {
        System.out.println(bookList.get(index));
        System.out.println("请输入要购买的数量：");
        count = sc.nextInt();
        orderItemList.add(new OrderItem(orderItemId, bookList.get(index), count));
    }

    /**
     * 初始化数据
     *
     * @param books      books
     * @param bookIdList bookIdList
     */
    private static void initData(List<Book> books, List<Integer> bookIdList) {
        books.add(new Book(1, "Java 程序开发", 30.6, 30));
        books.add(new Book(2, "C 语言程序设计", 40.6, 20));
        books.add(new Book(3, "HTML 网页开发", 50.6, 10));

        bookList.forEach(book -> bookIdList.add(book.getId()));
    }

    /**
     * 输出菜单
     *
     * @param books books
     */
    private static void printMenu(List<Book> books) {
        System.out.println("----------------------------------");
        System.out.println("| id | 名称         | 价格 |   库存  |");
        books.forEach(book ->
                System.out.println("|  " + book.getId() + " | " + book.getName() + " | " +
                        Integer.valueOf((book.getPrice() + "").split("\\.")[0]) + " 元 | " + book.getStorage() + " 本 |"));
        System.out.println("----------------------------------");

    }

    /**
     * 购物车
     *
     * @param orderItems  orderItems
     * @param orderItemId orderItemId
     */
    private static void buyCar(List<OrderItem> orderItems, Integer orderItemId) {
        double total = 0.0;
        System.out.println("=======购物车========");
        for (OrderItem item : orderItems) {
            if (Objects.equals(item.getId(), orderItemId)) {
                System.out.println(item);
                total += item.getBook().getPrice() * item.getCount();
            }
        }
        System.out.println("总价格为： " + (total + "").split("\\.")[0] + " 元");
        orderList.add(new Order(orderId, orderItems, total));
        orderId++;
        System.out.println("=======购物车========");
    }

    /**
     * 结账
     *
     * @param orders  orders
     * @param orderId orderId
     */
    private static void checkout(List<Order> orders, Integer orderId) {
        System.out.println("----------------------------");
        System.out.println("您的订单信息：");
        for (Order item : orders) {
            if (Objects.equals(item.getId(), orderId)) {
                System.out.println("商品：");
                item.getOrderItems().forEach(orderItem -> System.out.println("信息：" + orderItem.getBook().getName() + "数量：" + orderItem.getCount() + " 本"));
            }
            System.out.println("总价格：" + (item.getTotal() + "").split("\\.")[0] + " 元");
        }
        System.out.println("----------------------------");
        System.out.println("结账完成，欢迎下次光临");
    }


}
