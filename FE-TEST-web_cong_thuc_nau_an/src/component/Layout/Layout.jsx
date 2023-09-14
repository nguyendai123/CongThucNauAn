import React from "react";
import CustomFooter from "../Footer/Footer";
import CustomHeader from "../Header/Header";

const Layout = ({ children }) => {
  return (
    <div>
      <CustomHeader />
      <main style={{ minHeight: "calc(100vh - 64px - 70px)" }}>{children}</main>
      <CustomFooter />
    </div>
  );
};

export default Layout;
