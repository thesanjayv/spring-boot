// package com.example.demo.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.Address;
// import com.example.demo.repo.AddressRepo;

// @Service
// public class AddressService {
    
//     @Autowired
//     private AddressRepo addressRepo;

//     public Address createMethod(Address address){
//         return addressRepo.save(address);
//     }

//     //reading
//     public List<Address> getMethodService(){
//         return addressRepo.findAll();
//     }

//     //updating
//     public Address updatemethod(Integer id, Address address){
//         Optional<Address> op = addressRepo.findById(id);
//         if(op.isPresent()){
//             return addressRepo.save(address);
//         }
//         return null;
//     }

//     //deleteById
//     public void deleteId(Integer id){
//         addressRepo.deleteById(id);
//     }
//     //deletingTotalEntity
//     public void deleteMethod(Address Address){
//         addressRepo.delete(Address);
//     }
// }
