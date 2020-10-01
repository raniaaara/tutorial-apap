package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ResepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ResepController {
    @Autowired
    private ResepService resepService;

    // Routing URL yang diinginkan
    @RequestMapping("/resep/add")
    public String addResep(
            // Request parameter yang ingin dibawa
            @RequestParam(value = "noResep", required = true) String noResep,
            @RequestParam(value = "namaDokter", required = true) String namaDokter,
            @RequestParam(value = "namaPasien", required = true) String namaPasien,
            @RequestParam(value = "catatan", required = true) String catatan,
            Model model) {

        // Membuat objek ResepModel
        ResepModel resep = new ResepModel(noResep, namaDokter, namaPasien, catatan);

        // Memanggil service addResep
        resepService.addResep(resep);

        // Add variabel nomor resep ke 'nomorResep' untuk dirender pada thymeleaf
        model.addAttribute("nomorResep", noResep);

        // Return view template yang ingin digunakan
        return "add-resep";
    }

    @RequestMapping("/resep/viewall")
    public String listResep(Model model){

        // Mendapatkan semua ResepModel
        List<ResepModel> listResep = resepService.getResepList();

        // Add variabel semua ResepModel ke 'listResep' untuk dirender pada thymeleaf
        model.addAttribute("listResep", listResep);

        // Return view template yang ingin digunakan
        return "viewall-resep";
    }

    @RequestMapping("/resep/view")
    public String detailResep(
            @RequestParam(value = "noResep") String noResep,
            Model model){

        // Mendapatkan ResepModel sesuai nomor resep
        ResepModel resep = resepService.getResepByNomorResep(noResep);

        // Add variabel  ResepModel ke 'resep' untuk dirender pada thymeleaf
        model.addAttribute("resep", resep);

        // Return view template yang ingin digunakan
        return "view-resep";
    }

    // Latihan nomor 1
    @RequestMapping("/resep/view/no-resep/{noResep}")
    public String detailResepPathVariable(
            @PathVariable(value = "noResep") String noResep,
            Model model){
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        model.addAttribute("resep", resep);
        return "view-resep";
    }

    // Latihan nomor 2
    @RequestMapping("/resep/update/no-resep/{noResep}/catatan/{catatan}")
    public String editResep(
            @PathVariable(value = "noResep") String noResep,
            @PathVariable(value = "catatan") String catatan,
            Model model){
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        resep.setCatatan(catatan);
        model.addAttribute("noResep", noResep);
        return "edit-resep";
    }

    // Latihan nomor 3
    @RequestMapping("/resep/delete/no-resep/{noResep}")
    public String deleteResep(
            @PathVariable(value = "noResep") String noResep,
            Model model){
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        model.addAttribute("noResep", noResep);
        if(resep != null){
            resepService.getResepList().remove(resep);
            return "delete-resep";
        }
        return "delete-resep-gagal";
    }

}
