import React, { Component } from "react";
import Resep from "../../components/Resep";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/Button";
import Modal from "../../components/Modal";


class ResepList extends Component {          
    constructor(props) {
        super(props);
        this.state = {
            reseps: [],
            isLoading: false,
            isCreate: false,
            isEdit: false,
            namaDokter: "",
            namaPasien: "",
            catatan: "",
        };
        // this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleAddResep = this.handleAddResep.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleSubmitAddResep = this.handleSubmitAddResep.bind(this);
        this.handleEditResep = this.handleEditResep.bind(this);
        this.handleSubmitEditResep = this.handleSubmitEditResep.bind(this);
    }

    componentDidMount() {
        this.loadData();
    }

    async handleSubmitAddResep(event) {
        event.preventDefault();
        try {
            const data = {
                namaDokter: this.state.namaDokter,
                namaPasien: this.state.namaPasien,
                catatan: this.state.catatan,
            };
            await APIConfig.post("/resep", data);
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    handleAddResep() {
        this.setState({ isCreate: true });
    }

    handleCancel(event) {
        event.preventDefault();
        this.setState({
            namaDokter: "",
            namaPasien: "",
            catatan: "",
            isCreate: false,
            isEdit: false,
        });
    }

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    handleEditResep(resep) {
        this.setState({
          isEdit: true,
          noResep: resep.noResep,
          namaDokter: resep.namaDokter,
          namaPasien: resep.namaPasien,
          catatan: resep.catatan,
        });
      }
    
      async handleSubmitEditResep(event) {
        event.preventDefault();
        try {
          const data = {
            namaDokter: this.state.namaDokter,
            namaPasien: this.state.namaPasien,
            catatan: this.state.catatan,
          };
          await APIConfig.put(`/resep/${this.state.noResep}`, data);
          this.loadData();
        } catch (error) {
          alert("Oops terjadi masalah pada server");
          console.log(error);
        }
        this.handleCancel(event);
      }

    async handleDeleteResep(noResep) {
        try {
          await APIConfig.delete(`/resep/${noResep}`);
          this.loadData();
        } catch (error) {
          alert("Oops terjadi masalah pada server");
          console.log(error);
        }
      }

    // shouldComponentUpdate(nextProps, nextState) {
    //     console.log("shouldComponentUpdate()");
    //     return true;
    // }

    // handleClickLoading() {
    //     const currentLoading = this.state.isLoading;
    //     this.setState({ isLoading: !currentLoading });
    //     console.log(this.state.isLoading);
    // }

    async loadData() {
        try {
            const { data } = await APIConfig.get("/reseps");
            this.setState({ reseps: data });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }
        

    render() {
        return (
            <div className={classes.resepList}>
                <h1 className={classes.title}>All Reseps</h1>
                <Button onClick={this.handleAddResep} variant="primary">Add Resep</Button>
                <div>
                    {this.state.reseps.map((resep) => (
                    <Resep
                        key={resep.noResep}
                        noResep={resep.noResep}
                        namaDokter={resep.namaDokter}
                        namaPasien={resep.namaPasien}
                        catatan={resep.catatan}
                        handleEdit={() => this.handleEditResep(resep)}
                        handleDelete={() => this.handleDeleteResep(resep.noResep)}
                    />
                    ))}
                </div>  
                <Modal show={this.state.isCreate || this.state.isEdit} handleCloseModal={this.handleCancel}>
                    <form>
                        <h3 className={classes.modalTitle}>
                            {this.state.isCreate ? "Add Resep" : `Edit Resep Nomor ${this.state.noResep}`}
                        </h3>
                        <input
                            className={classes.textField}
                            type="text"
                            placeholder="Nama Dokter"
                            name="namaDokter"
                            value={this.state.namaDokter}
                            onChange={this.handleChangeField}
                        />
                        <input
                            className={classes.textField}
                            type="text"
                            placeholder="Nama Pasien"
                            name="namaPasien"
                            value={this.state.namaPasien}
                            onChange={this.handleChangeField}
                        />
                        <textarea
                            className={classes.textField}
                            placeholder="Catatan"
                            name="catatan"
                            rows="4"
                            value={this.state.catatan}
                            onChange={this.handleChangeField}
                        />
                        <Button onClick={this.state.isCreate ? this.handleSubmitAddResep : this.handleSubmitEditResep } variant="primary">
                            {this.state.isCreate ? "Create" : "Edit"}
                        </Button>
                        <Button onClick={this.handleCancel} variant="danger">
                            Cancel
                        </Button>
                    </form>
                </Modal>
            </div>
        );        
    }
}

export default ResepList;