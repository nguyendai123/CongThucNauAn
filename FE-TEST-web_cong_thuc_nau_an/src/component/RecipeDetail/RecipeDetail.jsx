import React from "react";
import { Typography, Image } from "antd";
import IngredientList from "../IngredientList/IngredientList";
import InstructionList from "../InstructionList/InstructionList";
const { Title } = Typography;

const RecipeDetail = ({ recipe }) => {
  return (
    <div>
      <Title level={2}>{recipe.title}</Title>
      <Image src={recipe.image} alt={recipe.title} />

      <IngredientList ingredients={recipe.ingredients} />

      <InstructionList instructions={recipe.instructions} />
    </div>
  );
};

export default RecipeDetail;
