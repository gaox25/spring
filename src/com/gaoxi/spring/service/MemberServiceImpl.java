package com.gaoxi.spring.service;

import com.gaoxi.spring.dao.MemberDAOImpl;

public class MemberServiceImpl {

    private MemberDAOImpl memberDAO;

    public MemberDAOImpl getMemberDAO() {
        return memberDAO;
    }

    public void setMemberDAO(MemberDAOImpl memberDAO) {
        this.memberDAO = memberDAO;
    }

    public void add() {
        System.out.println("MemberServiceImpl add()方法被调用");
        memberDAO.add();
    }
}
