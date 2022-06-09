package com.ravi.springsecurity.controller;

import com.ravi.springsecurity.dto.EmployeeDto;
import com.ravi.springsecurity.service.EmployeeService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

//@Transactional
public class EmployeeControllerTest {
//
//    private static final String ENDPOINT_URL = "/api/employee";
//    @InjectMocks
//    private EmployeeController employeeController;
//    @Mock
//    private EmployeeService employeeService;
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders
//                .standaloneSetup(employeeController)
//                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
//                //.addFilter(CustomFilter::doFilter)
//                .build();
//    }
//
//    @Test
//    public void findAllByPage() throws Exception {
//        Page<EmployeeDto> page = new PageImpl<>(Collections.singletonList(EmployeeBuilder.getDto()));
//
//        Mockito.when(employeeService.findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);
//
//        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));
//
//        Mockito.verify(employeeService, Mockito.times(1)).findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any());
//        Mockito.verifyNoMoreInteractions(employeeService);
//
//    }
//
//    @Test
//    public void getById() throws Exception {
//        Mockito.when(employeeService.findById(ArgumentMatchers.anyLong())).thenReturn(EmployeeBuilder.getDto());
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(employeeService, Mockito.times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(employeeService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        Mockito.when(employeeService.save(ArgumentMatchers.any(EmployeeDto.class))).thenReturn(EmployeeBuilder.getDto());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post(ENDPOINT_URL)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(CustomUtils.asJsonString(EmployeeBuilder.getDto())))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(employeeService, Mockito.times(1)).save(ArgumentMatchers.any(EmployeeDto.class));
//        Mockito.verifyNoMoreInteractions(employeeService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        Mockito.when(employeeService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(EmployeeBuilder.getDto());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(CustomUtils.asJsonString(EmployeeBuilder.getDto())))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(employeeService, Mockito.times(1)).update(ArgumentMatchers.any(EmployeeDto.class), ArgumentMatchers.anyLong());
//        Mockito.verifyNoMoreInteractions(employeeService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(employeeService).deleteById(ArgumentMatchers.anyLong());
//        mockMvc.perform(
//                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(CustomUtils.asJsonString(EmployeeBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(employeeService, Mockito.times(1)).deleteById(Mockito.anyLong());
//        Mockito.verifyNoMoreInteractions(employeeService);
//    }
}