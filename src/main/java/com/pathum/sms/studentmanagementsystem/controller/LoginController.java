package com.pathum.sms.studentmanagementsystem.controller;

import com.pathum.sms.studentmanagementsystem.view.Dashboard;

public class LoginController {

    public void openDashboard() {
        Dashboard dashboard = new Dashboard();
        dashboard.show();
    }
}