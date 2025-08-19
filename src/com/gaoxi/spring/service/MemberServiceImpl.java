package com.gaoxi.spring.service;

import com.gaoxi.spring.dao.MemberDAOImpl;

public class MemberServiceImpl {

    private MemberDAOImpl memberDAO;

    public MemberServiceImpl() {
        //System.out.println("MemberServiceImpl() 构造器被执行");
    }

    public MemberDAOImpl getMemberDAO() {
        return memberDAO;
    }

    public void setMemberDAO(MemberDAOImpl memberDAO) {
        //System.out.println("setMemberDAO()...");
        this.memberDAO = memberDAO;
    }

    public void add() {
        System.out.println("MemberServiceImpl add()方法被调用");
        memberDAO.add();
    }
}
