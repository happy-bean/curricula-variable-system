package edu.dao;

import edu.model.CurriculaVariableInfo;

public interface CurriculaVariableInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curricula_variable_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curricula_variable_info
     *
     * @mbggenerated
     */
    int insert(CurriculaVariableInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curricula_variable_info
     *
     * @mbggenerated
     */
    int insertSelective(CurriculaVariableInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curricula_variable_info
     *
     * @mbggenerated
     */
    CurriculaVariableInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curricula_variable_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CurriculaVariableInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table curricula_variable_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CurriculaVariableInfo record);
}