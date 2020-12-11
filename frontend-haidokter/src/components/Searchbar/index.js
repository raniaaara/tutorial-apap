import React from "react";
import classes from "./styles.module.css";

const SearchBar = (props) => {
    return (
        <input
            type="search"
            placeholder={"Search doctor"}
            onChange={props.handleChange}
        />
    );
}

export default SearchBar;