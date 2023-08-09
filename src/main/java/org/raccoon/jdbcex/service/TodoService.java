package org.raccoon.jdbcex.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.raccoon.jdbcex.dao.TodoDAO;
import org.raccoon.jdbcex.domain.TodoVO;
import org.raccoon.jdbcex.dto.TodoDTO;
import org.raccoon.jdbcex.util.MapperUtil;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();

    }

    public void register(TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
//        System.out.println("todoVO: " + todoVO);
        log.info(todoVO);
        dao.insert(todoVO);
    }
}
