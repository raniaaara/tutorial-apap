import React from "react";
import classes from "./styles.module.css";
import Button from "../Button";

const Resep = (props) => {
    const { noResep, namaDokter, namaPasien, catatan, listObat, handleDelete, handleEdit } = props;
    return (
        <div className={classes.resep}>
            <h3>{`Resep Nomor ${noResep}`}</h3>
            <p>{`Nama Dokter: ${namaDokter}`}</p>
            <p>{`Nama Pasien: ${namaPasien}`}</p>
            <p>{`Nama Catatan: ${catatan}`}</p>
            <div className={classes.obat}>
                {listObat.length ? listObat : "Resep tidak memiliki obat" }
            </div>
            <br/>
            <Button onClick={handleEdit} variant="success">
                Edit
            </Button>
            <Button onClick={handleDelete} variant="danger">
                Delete
            </Button>
        </div>
    );
};

export default Resep;