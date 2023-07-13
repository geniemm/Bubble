package bubble_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bubble_common.BubbleConnect;
import bubble_dto.BubbleDTO;

public class BubbleDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public BubbleDAO() {
		con = BubbleConnect.getConnect();
	} 
	   public ArrayList<BubbleDTO> getList1() {
		      ArrayList<BubbleDTO> list1 = new ArrayList<>();
		      String sqlb = "select * from bubble where drink= '버블티'";
		      try {
		         ps = con.prepareStatement(sqlb);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		             BubbleDTO dto = new BubbleDTO();
		            dto.setMenu(rs.getString("b_name"));
		            dto.setPrice(rs.getInt("price"));
		            list1.add(dto);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return list1;
		      
		}
		  
		   public ArrayList<BubbleDTO> getList2() {
		      ArrayList<BubbleDTO> list2 = new ArrayList<>();
		      String sqlc = "select * from bubble where drink= '커피'";
		      //      String sql = "select * from bubble";
		      try {
		         ps = con.prepareStatement(sqlc);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		            BubbleDTO dto = new BubbleDTO();
		            dto.setMenu(rs.getString("b_name"));
		            dto.setDrink(rs.getString("drink"));
		            dto.setPrice(rs.getInt("price"));

		            list2.add(dto);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return list2;
		      
		}
		   public ArrayList<BubbleDTO> getList3() {

		      ArrayList<BubbleDTO> list3 = new ArrayList<>();
		      String sqls = "select * from bubble where drink= '스무디'";
		      //      String sql = "select * from bubble";
		      try {
		         ps = con.prepareStatement(sqls);
		         rs = ps.executeQuery();
		         while(rs.next()) {
		            BubbleDTO dto = new BubbleDTO();
		            dto.setMenu(rs.getString("b_name"));
		            dto.setDrink(rs.getString("drink"));
		            dto.setPrice(rs.getInt("price"));
		           

		            list3.add(dto);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return list3;
		      
		}
		   
		   
		   public int insert(BubbleDTO dto) {
			String sql = "insert into option_(num_,b_name,b_size,ice,pearl,add_pearl,sweet) values(option_SEQ.nextVAL,?,?,?,?,?,?)";
			
			int result = 0;
			try {
				ps= con.prepareStatement(sql);
				
				//ps.equals(dto.getSize());
				ps.setString(1, dto.getMenu());
				ps.setString(2, dto.getSize());
				ps.setString(3, dto.getIce());
				ps.setString(4, dto.getPearl());
				ps.setString(5, dto.getAddPearl());
				ps.setInt(6, dto.getSweet());
				result = ps.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			} return result;
		   }
		   
		   
		   public int addPrice(String cho) {
		       String sql = "select price from bubble where b_name = '"+cho+"'";
		       
		       int price = 0;
		       
		       try {
		           ps = con.prepareStatement(sql);
		           rs = ps.executeQuery();
		           if (rs.next()) {
		               price = rs.getInt("price");
		           }
		       }catch(Exception e) {
		           e.printStackTrace();
		       }
		       return price;
		   }
		   
			   
			public ArrayList<BubbleDTO> getList() {
				ArrayList<BubbleDTO> orderList= new ArrayList<>();
				String sql = "select option_.num_,option_.b_name,option_.b_size,option_.ice,option_.pearl,option_.add_pearl,option_.sweet,bubble.price from bubble inner join option_ on bubble.b_name = option_.b_name";
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					while (rs.next()) {
						BubbleDTO dto = new BubbleDTO();
						
						dto.setNum(rs.getInt("num_"));
						dto.setMenu(rs.getString("b_name"));
						dto.setSize(rs.getString("b_size"));
						dto.setIce(rs.getString("ice"));
						dto.setPearl(rs.getString("pearl"));
						dto.setAddPearl(rs.getString("add_pearl"));
						dto.setSweet(rs.getInt("sweet"));
						dto.setPrice(rs.getInt("price"));
						

						orderList.add(dto);
					}
				}
					catch (Exception e) {
						e.printStackTrace();	

					}
					return orderList;
				}
		
			}




