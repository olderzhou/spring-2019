package com.klaus.interview.springredis;


import com.klaus.interview.springredis.service.PersonService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@ActiveProfiles("test")
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
//@PrepareForTest({PersonService.class})
@PowerMockIgnore({"javax.management.*", "javax.net.ssl.*"})
@SpringBootTest
public class TestController {


//    @Autowired
//    private WebApplicationContext context;
//
//    private MockMvc mvc;

    @Mock
    private PersonService personService;


    @Before
    public void setUp() {

        personService.findAll();

    }

//    @Autowired
//    private PersonServiceImpl personServiceImpl;

//    @Before
//    public void setUp() throws Exception {
//        mvc = MockMvcBuilders.webAppContextSetup(context).build();
//        // 使用反射将IOC容器注入的service的属性替换指定为mock的对象
////        ReflectionTestUtils.setField(personServiceImpl, "basicService", personService);
//        Person person = new Person();
//        person.setName("klaus");
//        PowerMockito.when(this.personService, "birth", person).thenReturn(Optional.empty());
////    }

//    @Test
//    @Transactional
//    public void testA() throws Exception {
//        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/v1/cars")
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .accept(MediaType.APPLICATION_JSON)
//        ).andExpect(status().isOk())
//                .andExpect(handler().handlerType(PersonController.class))
//                .andExpect(handler().methodName("search"))
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//        JSONObject object = JSON.parseObject(result.getResponse().getContentAsString(), JSONObject.class);
//        Assert.assertThat("数据量不是2", object.getJSONObject("data").getJSONArray("list").size(), Is.is(2));
//    }












}
