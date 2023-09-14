import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Layout, Typography } from "antd";
import RecipeList from "../RecipeList/RecipeList";
import Header from "../Header/Header";
import Footer from "../Footer/Footer";
import SearchBar from "../SearchBar/SearchBar";
import recipesData from "../recipesData/recipesData";

const { Content } = Layout;
const { Title } = Typography;

const Home = () => {
  const [searchResults, setSearchResults] = useState(recipesData);
  const navigate = useNavigate();

  return (
    <Layout>
      <Content style={{ padding: "50px" }}>
        <Title level={2}>Trang chủ</Title>

        <div style={{ marginBottom: "20px" }}>
          <SearchBar setSearchResults={setSearchResults} />
        </div>

        <RecipeList recipes={searchResults} />

        <ul style={{ marginTop: "20px" }}>
          {/* Hiển thị danh sách công thức nấu ăn */}
          <li>Công thức 1</li>
          <li>Công thức 2</li>
          <li>Công thức 3</li>
        </ul>
      </Content>
    </Layout>
  );
};

export default Home;
