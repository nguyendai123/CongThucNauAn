import React from "react";
import { Typography } from "antd";
import RecipeDetail from "../RecipeDetail/RecipeDetail";

const { Title } = Typography;

const RecipePage = () => {
  const recipe = {
    title: "Công thức nấu ăn",
    image: "path/to/image.jpg",
    ingredients: ["Thành phần 1", "Thành phần 2", "Thành phần 3"],
    instructions: ["Bước 1", "Bước 2", "Bước 3"],
  };

  return (
    <div>
      <Title level={1}>Trang chi tiết công thức nấu ăn</Title>
      <RecipeDetail recipe={recipe} />
    </div>
  );
};

export default RecipePage;
