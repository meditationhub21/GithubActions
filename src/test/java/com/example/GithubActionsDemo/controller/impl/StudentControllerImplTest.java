package com.example.GithubActionsDemo.controller.impl;

import com.example.GithubActionsDemo.builder.StudentBuilder;
import com.example.GithubActionsDemo.entity.Student;
import com.example.GithubActionsDemo.mapper.StudentMapper;
import com.example.GithubActionsDemo.service.StudentService;
import com.example.GithubActionsDemo.util.CustomUtils;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"classpath:application-test.properties"})
@ActiveProfiles("test")
public class StudentControllerImplTest {
    //TODO: create the data Test generator class StudentBuilder
    private static final String ENDPOINT_URL = "/api/student";
    @InjectMocks
    private StudentControllerImpl studentController;
    @Mock
    private StudentService studentService;
    @Mock
    private StudentMapper studentMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.studentController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(studentMapper.asDTOList(ArgumentMatchers.any())).thenReturn(StudentBuilder.getListDTO());

        Mockito.when(studentService.findAll()).thenReturn(StudentBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(studentMapper.asDTO(ArgumentMatchers.any())).thenReturn(StudentBuilder.getDTO());

        Mockito.when(studentService.findById(ArgumentMatchers.anyInt())).thenReturn(java.util.Optional.of(StudentBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/101"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(101)));
        Mockito.verify(studentService, Mockito.times(1)).findById(101);
        Mockito.verifyNoMoreInteractions(studentService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(studentMapper.asEntity(ArgumentMatchers.any())).thenReturn(StudentBuilder.getEntity());
        Mockito.when(studentService.save(ArgumentMatchers.any(Student.class))).thenReturn(StudentBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(StudentBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(studentService, Mockito.times(1)).save(ArgumentMatchers.any(Student.class));
        Mockito.verifyNoMoreInteractions(studentService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(studentMapper.asEntity(ArgumentMatchers.any())).thenReturn(StudentBuilder.getEntity());
        Mockito.when(studentService.update(ArgumentMatchers.any(), ArgumentMatchers.anyInt())).thenReturn(StudentBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(StudentBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(studentService, Mockito.times(1)).update(ArgumentMatchers.any(Student.class), ArgumentMatchers.anyInt());
        Mockito.verifyNoMoreInteractions(studentService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(studentService).deleteById(ArgumentMatchers.anyInt());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(studentService, Mockito.times(1)).deleteById(Mockito.anyInt());
        Mockito.verifyNoMoreInteractions(studentService);
    }
}