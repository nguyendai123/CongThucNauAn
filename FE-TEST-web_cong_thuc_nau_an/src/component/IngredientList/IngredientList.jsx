import { Typography } from "antd";
const { Title, Text } = Typography;

const CustomIngredientList = ({ ingredients }) => {
  return (
    <div>
      <Title level={3}>Thành phần:</Title>
      <ul>
        {ingredients.map((ingredient, index) => (
          <li key={index}>
            <Text>{ingredient}</Text>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CustomIngredientList;
