import { Typography } from "antd";

const { Title, Paragraph } = Typography;

const NotFound = () => {
  return (
    <div>
      <Title level={1}>404 - Không tìm thấy trang</Title>
      <Paragraph>Xin lỗi, trang bạn đang tìm kiếm không tồn tại.</Paragraph>
    </div>
  );
};

export default NotFound;
