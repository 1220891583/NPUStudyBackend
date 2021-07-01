package com.hhstudygroup.npustudy.viewmodel;

import com.hhstudygroup.npustudy.utility.ModelMapperSingle;
import org.modelmapper.ModelMapper;

/**
 * @author HHStudyGroup
 */

public class BaseVM {
    protected static ModelMapper modelMapper = ModelMapperSingle.Instance();


    public static ModelMapper getModelMapper() {
        return modelMapper;
    }

    public static void setModelMapper(ModelMapper modelMapper) {
        BaseVM.modelMapper = modelMapper;
    }
}
