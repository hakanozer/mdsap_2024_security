package com.works.services;

import com.works.entities.Customer;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
@RequiredArgsConstructor
public class LoginService {

    final DB db;
    final HttpServletRequest request;

    public boolean login(Customer customer) {
        boolean status = false;
        try {
            String sql = "select * from customer where email = ? and password = ?";
            PreparedStatement st = db.dataSource().getConnection().prepareStatement(sql);
            st.setString(1, customer.getEmail());
            st.setString(2, customer.getPassword());
            ResultSet rs = st.executeQuery();
            status = rs.next();
            /*
            String sql = "select * from customer where email = '"+customer.getEmail()+"' and password = '"+ customer.getPassword()+"'";
            Statement st = db.dataSource().getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            status = rs.next();
             */
            if (status) {
                String name = rs.getString("name");
                int cid = rs.getInt("cid");
                customer.setCid(cid);
                customer.setName(name);
                customer.setPassword(null);
                request.getSession().setAttribute("customer", customer);
            }
        }catch (Exception ex) {
            System.err.println("Login Error : " + ex);
        }

        return status;
    }

}
