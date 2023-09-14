import React from "react";
import { Typography, Image } from "antd";
import recipesData from "../recipesData/recipesData";
const { Title, Paragraph } = Typography;

const RecipeList = ({ recipes }) => {
  if (recipes == null) recipes = recipesData;
  return (
    <div>
      <Title level={2}>Danh sách công thức nấu ăn</Title>
      {recipes.map((recipe, index) => (
        <div key={index}>
          <Title level={3}>{recipe.title}</Title>
          <Image src={recipe.image} alt={recipe.title} />
          <Paragraph>{recipe.description}</Paragraph>
        </div>
      ))}
    </div>
  );
};

export default RecipeList;
