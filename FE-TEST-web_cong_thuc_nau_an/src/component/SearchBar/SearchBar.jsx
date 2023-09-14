import React, { useState } from "react";
import { Input, Button, Select } from "antd";
import diacriticless from "diacriticless";
const { Option } = Select;
const recipes = [
  {
    id: 1,
    type: "dish",
    title: "Mì xào hải sản",
    image: "https://example.com/mi-xao-hai-san.jpg",
    ingredients: ["Gà", "Mì xào", "Hải sản", "Rau sống"],
    steps: [
      "Bước 1: Chuẩn bị nguyên liệu",
      "Bước 2: Nấu mì và xào hải sản",
      "Bước 3: Trang trí và thưởng thức",
    ],
  },
  {
    id: 2,
    type: "dish",
    title: "Gà nướng mật ong",
    image: "https://example.com/ga-nuong-mat-ong.jpg",
    ingredients: ["Gà", "Mật ong", "Gia vị"],
    steps: [
      "Bước 1: Chuẩn bị nguyên liệu",
      "Bước 2: Nướng gà với mật ong",
      "Bước 3: Trang trí và thưởng thức",
    ],
  },
  // Thêm các công thức khác
];

const SearchBar = ({ setSearchResults }) => {
  const [searchTerm, setSearchTerm] = useState("");
  const [searchType, setSearchType] = useState("ingredient");
  const [searchValue, setSearchValue] = useState("");
  const handleSearchTermChange = (event) => {
    setSearchTerm(event.target.value);
  };
  const handleSearchTypeChange = (event) => {
    setSearchType(event.target.value);
  };
  const handleSearchValueChange = (event) => {
    setSearchValue(event.target.value);
  };

  const performFilter = (searchTerm, searchType) => {
    // Thực hiện logic tìm kiếm công thức nấu ăn dựa trên searchTerm và searchType
    // Trả về kết quả tìm kiếm

    // Ví dụ: Giả sử có một danh sách công thức nấu ăn

    // Lọc danh sách công thức dựa trên searchTerm và searchType
    const filteredRecipes = recipes.filter((recipe) => {
      if (searchType === "ingredient") {
        // Tìm kiếm theo nguyên liệu
        return recipe.ingredients.includes(searchTerm);
      } else if (searchType === "dish") {
        // Tìm kiếm theo món ăn
        return recipe.type === "dish" && recipe.title.includes(searchTerm);
      }

      return false;
    });

    return filteredRecipes;
  };

  const handleFilter = () => {
    // Xử lý tìm kiếm dựa trên searchTerm và searchType
    console.log(`Searching for ${searchTerm} by ${searchType}`);
    // Gán kết quả tìm kiếm vào searchResults
    // Thực hiện tìm kiếm công thức nấu ăn dựa trên searchTerm và searchType
    const results = performFilter(searchTerm, searchType);

    // Cập nhật kết quả tìm kiếm vào state
    setSearchResults(results);
    console.log(`Searching ` + results);
  };
  const performSearch = (searchValue) => {
    // Thực hiện logic tìm kiếm công thức nấu ăn dựa trên searchValue và searchType
    // Trả về kết quả tìm kiếm

    // Ví dụ: Giả sử có một danh sách công thức nấu ăn
    // Lọc danh sách công thức dựa trên searchValue và searchType
    const filteredRecipes = recipes.filter((recipe) => {
      // Tìm kiếm theo nguyên liệu
      const normalizedSearchValue = diacriticless(searchValue.toLowerCase());

      return (
        recipe.ingredients.some(
          (ingredient) =>
            diacriticless(ingredient.toLowerCase()) === normalizedSearchValue
        ) ||
        diacriticless(recipe.title.toLowerCase()).includes(
          normalizedSearchValue
        ) ||
        recipe.steps.some((step) =>
          diacriticless(step.toLowerCase()).includes(normalizedSearchValue)
        )
      );
    });

    return filteredRecipes;
  };
  const handleSearch = () => {
    // Xử lý tìm kiếm dựa trên searchTerm và searchType
    // Gán kết quả tìm kiếm vào searchResults
    // Thực hiện tìm kiếm công thức nấu ăn dựa trên searchTerm và searchType
    const results = performSearch(searchValue);

    // Cập nhật kết quả tìm kiếm vào state
    setSearchResults(results);
    console.log(`Searching ` + results);
  };
  return (
    <div>
      <Input
        value={searchValue}
        onChange={handleSearchValueChange}
        placeholder="Tìm kiếm tên nguyên liệu hoặc món ăn..."
      />
      <Button onClick={handleSearch} type="primary">
        Tìm kiếm
      </Button>
      <Input
        value={searchTerm}
        onChange={handleSearchTermChange}
        placeholder="Nhập nguyên liệu hoặc món ăn..."
      />
      <Select value={searchType} onChange={handleSearchTypeChange}>
        <Option value="ingredient">Nguyên liệu</Option>
        <Option value="dish">Món ăn</Option>
      </Select>
      <Button onClick={handleFilter} type="primary">
        Lọc
      </Button>
    </div>
  );
};

export default SearchBar;
