小芳便利店作业要求



版本要求：

- 程序体现面向对象的编程思想；

- 要求能够灵活添加新物品，并向用户提供多次购买一次性结帐的功能；

提示：可用以下三个类解决该问题

货物类（Goods）：一个商品，包含了名称，价格信息

| **Goods**                                                    |
| ------------------------------------------------------------ |
| -String name<br />-float price                               |
| +Goods(String _name,float _price)<br />+void setName(String _name)<br />+String getName()<br />+void setPrice(float _price)<br />+float getPrice() |

1. 购物篮类（Basket）：一个购物篮，包含了已经选择的东西

   | **Basket**                                                   |
   | ------------------------------------------------------------ |
   | -ArrayList<Goods> goodsList                                  |
   | +void addGoods(Goods goods)<br />+ArrayList<Goods> getAllGoods()<br />+boolean isEmpty()<br />+void clear()<br />+float getTotalPrice() |

   

2. Store：小芳便利店 主程序

   | **Store**                                                    |
   | ------------------------------------------------------------ |
   | -static final Goods[] GOODS //所有商品<br />-static Basket basket //存放选中商品的购物篮<br />-static final String MESSAGE_HEADER //菜单顶部<br />-static final String MESSAGE_FOOTER //菜单底部 |
   | -static void exit() //打印消息退出整个程序<br />-static void checkOut() //买单，打印所有已经选择的商品<br />-static void invalidInput() //当输入错误的时候，打印消息<br />-static void addGoods(int choice) //添加选中的商品到购物篮<br />-static void printMenu() //打印菜单<br />+static void main(String args[]) //程序入口 |
   |                                                              |

   

还有一些界面要求，已在程序中体现。