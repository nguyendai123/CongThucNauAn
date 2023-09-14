import { Typography } from "antd";
const { Title } = Typography;

const CustomInstructionList = ({ instructions }) => {
  return (
    <div>
      <Title level={3}>Hướng dẫn:</Title>
      <ol>
        {instructions.map((instruction, index) => (
          <li key={index}>{instruction}</li>
        ))}
      </ol>
    </div>
  );
};

export default CustomInstructionList;
