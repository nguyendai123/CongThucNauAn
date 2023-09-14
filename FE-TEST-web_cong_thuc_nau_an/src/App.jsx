import React from "react";
import { BrowserRouter, Routes, Route, Outlet } from "react-router-dom";
import Home from "./component/Home/Home";
import NotFound from "./component/NotFound/NotFound";
import RecipeList from "./component/RecipeList/RecipeList";
import RecipeDetail from "./component/RecipeDetail/RecipeDetail";
import CustomHeader from "./component/Header/Header";
import Layout from "./component/Layout/Layout";

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route
          path="/"
          element={
            <Layout>
              <Outlet />
            </Layout>
          }
        >
          <Route path="/" element={<Home />} />
          <Route path="/recipes" element={<RecipeList />} />
        </Route>
        <Route path="/recipes/:id" element={<RecipeDetail />} />
        <Route element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
};

export default App;
