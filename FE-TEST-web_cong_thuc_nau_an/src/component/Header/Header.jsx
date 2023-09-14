import React from "react";
import { Layout, Menu, Image } from "antd";
import { Link, useLocation } from "react-router-dom";
import logo from "../../assets/react.svg";

const { Header } = Layout;

const CustomHeader = () => {
  const location = useLocation();

  return (
    <Header>
      <Menu theme="dark" mode="horizontal" selectedKeys={[location.pathname]}>
        <Menu.Item key="logo">
          <Link to="/">
            <Image src={logo} alt="Logo" preview={false} />
          </Link>
        </Menu.Item>
        <Menu.Item key="/">
          <Link to="/">Trang chủ</Link>
        </Menu.Item>
        <Menu.Item key="/recipes">
          <Link to="/recipes">Công thức</Link>
        </Menu.Item>
        <Menu.Item key="/about">
          <Link to="/about">Giới thiệu</Link>
        </Menu.Item>
      </Menu>
    </Header>
  );
};

export default CustomHeader;
