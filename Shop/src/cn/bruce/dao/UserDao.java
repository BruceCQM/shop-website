package cn.bruce.dao;

import cn.bruce.domain.Goods;
import cn.bruce.domain.User;
import cn.bruce.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * 对数据库的操作在这里
 */
public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    //用户登录
    public User login(User loginUser)
    {
        try {
            String sql = "select * from user_info where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    //用户注册
    public int register(User registerUser){
        String sql = "insert into user_info values(null,?,?)";
        int count = template.update(sql, registerUser.getUsername(), registerUser.getPassword());
        return count;
    }

    /**
     *对商品表的操作
     */
    //添加商品
    public int addGoods(Goods goods){
        String sql = "insert into goods values(?,?,?)";
        int count = template.update(sql, goods.getId(), goods.getGoodsname(), goods.getPrice());
        return count;
    }

    //删除商品
    public int delGoods(int id){
        String sql = "delete from goods where id = ?";
        int count = template.update(sql, id);
        return count;
    }

    //修改商品信息
    public int changeGoods(int oldId,String item,String info){
        int count = 0;
        if("1".equals(item)){
            String sql = "update goods set id = ? where id = ?";
            count = template.update(sql, info, oldId);
        }else if("2".equals(item)){
            String sql = "update goods set goodsname = ? where id = ?";
            count = template.update(sql,info,oldId);
        }else if("3".equals(item)){
            String sql = "update goods set price = ? where id = ?";
            count = template.update(sql,info,oldId);
        }
        return count;
    }

    //根据ID号查询商品
    public Map<String, Object> searchGood(int id){
        try {
            String sql = "select * from goods where id = ?";
            Map<String, Object> map = template.queryForMap(sql, id);
            return map;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        //没有商品返回null
        return null;
    }

    //根据价格范围查询商品
    public List searchGood(int price1,int price2){
        String sql = "select * from goods where (price between ? and ?)";
        List<Map<String, Object>> list = template.queryForList(sql, price1, price2);
        return list;
    }

    //查询所有商品信息
    public List showGoods(){
        String sql = "select * from goods";
        List<Map<String, Object>> list = template.queryForList(sql);
        return list;
    }

    /**
     *对购物车表的操作
     */
    //修改购物车的商品信息
    public int changeCart(int oldId,String item,String info){
        int count = 0;
        if("1".equals(item)){
            String sql = "update cart set id = ? where id = ?";
            count = template.update(sql, info, oldId);
        }else if("2".equals(item)){
            String sql = "update cart set goodsname = ? where id = ?";
            count = template.update(sql,info,oldId);
        }else if("3".equals(item)){
            String sql = "update cart set price = ? where id = ?";
            count = template.update(sql,info,oldId);
        }
        return count;
    }

    //查询购物车表,返回所有信息
    public List showCart(){
        String sql = "select * from cart";
        List<Map<String, Object>> list = template.queryForList(sql);
        return list;
    }

    //根据ID号删除购物车的商品
    public int delCart(int id){
        String sql = "delete from cart where id = ?";
        int count = template.update(sql, id);
        return count;
    }

    //把单件商品加入购物车表
    public int addCart(Map<String, Object> map){
        String sql = "insert into cart values(?,?,?)";
        int count = template.update(sql, map.get("id"), map.get("goodsname"), map.get("price"));
        return count;
    }

    /**
     *对销售报表的操作
     */
    //修改销售报表的商品基本信息
    public int changeFinance(String oldId,String item,String info){
        int count = 0;
        if("1".equals(item)){
            String sql = "update cart set id = ? where id = ?";
            count = template.update(sql, info, oldId);
        }else if("2".equals(item)){
            String sql = "update cart set goodsname = ? where id = ?";
            count = template.update(sql,info,oldId);
        }
        return count;
    }

    //根据ID号查询销售报表是否存在对应商品
    public Map<String, Object> searchFinance(String id){
        try {
            String sql = "select * from finance where id = ?";
            Map<String, Object> map = template.queryForMap(sql, id);
            return map;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    //更新销售报表
    public void updateFinance(String id){
        Map<String, Object> map = this.searchFinance(id);
        Map<String, Object> map1 = this.searchGood(Integer.parseInt(id));
        //销售报表没有该商品的销售记录,即这是第一条销售记录
        if(map == null && map1 != null){
            String sql = "insert into finance values(?,?,?,?)";
            template.update(sql, id, map1.get("goodsname"), 1, map1.get("price"));
        }
        else if(map != null && map1 != null){
            String sql = "update finance set sellNumber = sellNumber + 1, profit = ? where id = ?";
            int newProfit = (int)map.get("profit") + (int)map1.get("price");
            template.update(sql, newProfit,id);
        }
    }

    //查询销售报表所有信息
    public List showFinance(){
        String sql = "select * from finance order by profit desc";
        List<Map<String, Object>> list = template.queryForList(sql);
        return list;
    }

    /**
     * 对购买记录表的操作
     */
    //添加新的购买记录
    public int addPurchase(String username,Map<String,Object> map,String buyTime){
        String sql = "insert into purchase values(?,?,?,?,?)";
        int count = template.update(sql, username, map.get("id"), map.get("goodsname"), map.get("price"), buyTime);
        return count;
    }
    //查询购买记录表所有记录
    public List showPurchase(){
        String sql = "select * from purchase order by buyTime desc ";
        List<Map<String, Object>> list = template.queryForList(sql);
        return list;
    }
}
