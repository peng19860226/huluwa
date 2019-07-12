package com.uap;



import com.alibaba.fastjson.JSON;
import com.uap.ez.controller.EzAccountbookController;
import com.uap.ez.entity.EzAccountbook;
import com.uap.model.utils.Page;
import com.uap.model.utils.Result;


import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



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
    private EzAccountbookController sitesController;

    @Test
    public void testSelectByPage() {
    	
//    	Result<List<EzAccountbook>> aaa = sitesController.selectAll();
//        Page<EzAccountbook> page = new Page<EzAccountbook>();
//        page.setOffset(0);
//        page.setPageSize(10);
//        EzAccountbook sites = new EzAccountbook();
//        // sites.setUrl("http://andorralavella.ad/");
//        sites.
//        page.setObj(sites);
//        Result<Page<List<EzAccountbook>>> result = sitesController.selectByPage(page);
//        if (result.getData().getObj() != null) {
//            result.getData().getObj().forEach((s) -> System.out.println( JSON.toJSONString(s)));
//        }
    }
//    @Test
//    public void insertAccountBook() {
//    	EzAccountbook record=new EzAccountbook();
//    	record.setAmount(BigDecimal.valueOf(100));
//    	record.setId(1);
//    	record.setPersonnum(1);
//    	record.setHotelname("七天酒店");
//    	record.setInvoicetype("1");
//    	record.setOstctype(1);
//    	sitesController.insertSelective(record);
//    }
//  @Test
//  public void deleteEzAccountBook() {
//  	
//  	sitesController.deleteByPrimaryKey(15);
//  }
  @Test
  public void updateEzAccountBook() {
	  Result<EzAccountbook> accbook=sitesController.selectByPrimaryKey(16);
	  accbook.getData().setHotelname(accbook.getData().getHotelname()+"1");
  	sitesController.updateByPrimaryKeySelective(accbook.getData());
  }
}
