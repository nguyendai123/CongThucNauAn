import React from "react";
import { Layout, Typography } from "antd";
const { Footer } = Layout;
const { Text } = Typography;

const CustomFooter = () => {
  return (
    <Footer style={{ textAlign: "center" }}>
      <Text>Copy right © 2023 by Nguyễn Văn Đại</Text>
    </Footer>
  );
};

export default CustomFooter;
