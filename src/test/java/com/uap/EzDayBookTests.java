package com.uap;





import com.alibaba.fastjson.JSON;
import com.uap.ez.controller.AccountbookController;
import com.uap.ez.dto.AccountbookDto;
import com.uap.ez.service.impl.AccountbookServiceImpl;


import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;




@RunWith(SpringRunner.class)
@SpringBootTest
public class EzDayBookTests {

	
//	private MockMvc mvc;
//    @Before
//    public void setUp() throws Exception {
//        mvc = MockMvcBuilders.standaloneSetup(new EzAccountbookController()).build();
//    }
//    @Test
//    public void getHello() throws Exception {
//    mvc.perform(MockMvcRequestBuilders.post("/selectAll").accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//    }

    @Autowired
    private AccountbookController sitesController;
	 @Autowired
	 private AccountbookServiceImpl ezAccountbookServiceImpl;
//    @Test
//    public void testSelectByPage() {
//    	
////    	Result<List<EzAccountbook>> aaa = sitesController.selectAll();
//    	
////        if (result.getData().getRecords()!= null) {
//////        	
////        	for (EzAccountbook map:result.getData().getRecords()) {
////        		System.out.println( JSON.toJSONString(instance.entityToDto(map)));
////			}
////           // result.getData().getRecords().forEach((s) -> System.out.println( JSON.toJSONString(s)));
////        }
//    }
    @Test
    public void insertAccountBook() {
    	
//    	for (int i = 0; i < 5; i++) {
//    		AccountbookDto record=new AccountbookDto();
//        	record.setAmount(BigDecimal.valueOf(100));
//        	
//        	record.setPersonnum(1);
//        	record.setHotelname("七天酒店");
//        	record.setInvoicetype("1");
//        	record.setOstctype(1);
//        	ezAccountbookServiceImpl.create(record);
//		}
    	AccountbookDto dto = sitesController.findbyId("08d4825c-2fd3-453f-bde9-28d3d57c79c9");
    	System.out.print(JSON.toJSONString(dto));
    	for (int i = 0; i < 5; i++) {
    		AccountbookDto record=new AccountbookDto();
        	record.setAmount(BigDecimal.valueOf(100));
        	
        	record.setPersonnum(1);
        	record.setHotelname("七天酒店");
        	record.setInvoicetype("1");
        	record.setOstctype(1);
//        	ezAccountbookServiceImpl.create(record);
        	sitesController.create(record);
        	
		}
    }
//  @Test
//  public void deleteEzAccountBook() {
//  	
//  	sitesController.deleteByPrimaryKey(15);
//  }
//  @Test
//  public void updateEzAccountBook() {
//	  Result<EzAccountbook> accbook=sitesController.selectByPrimaryKey(16);
//	  accbook.getData().setHotelname(accbook.getData().getHotelname()+"1");
//  	sitesController.updateByPrimaryKeySelective(accbook.getData());
//  }
}
