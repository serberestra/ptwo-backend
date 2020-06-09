package com.ptwo.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptwo.app.dao.CompanyDao;
import com.ptwo.app.dao.ReservationDAO;
import com.ptwo.app.dao.UserDAO;
import com.ptwo.app.dao.WorkerDao;
import com.ptwo.app.model.Company;
import com.ptwo.app.model.Reservation;
import com.ptwo.app.model.User;
import com.ptwo.app.model.Worker;
import com.ptwo.app.service.CompanyService;
import com.ptwo.app.service.ReservationService;
import com.ptwo.app.service.UserService;
import com.ptwo.app.service.WorkerService;
import com.ptwo.app.viewModel.ReservationViewModel;

@Service
public class ReservationViewModelServiceImpl {
	
	private CompanyService companyService;
	private WorkerService workerService;
	private UserService userService;
	private ReservationService reservationService;
	
	@Autowired
	public ReservationViewModelServiceImpl(CompanyService companyService, WorkerService workerService,
			UserService userService, ReservationService reservationService) {
		this.companyService = companyService;
		this.workerService = workerService;
		this.userService = userService;
		this.reservationService = reservationService;
	}

	/*
	 * saveServiceRowViewModel to save data in reservation table. 
	 *  
     * Mapping:
     * private Long reservationId;    <-- leave blank when adding (auto-generated)
     * 
     * private String service;        <-- from worker record
     * private Long companyId;        <-- from worker record
     * private Long workerId;         <-- from worker record
     * private String firstlName;     <-- from worker record
     * private String lastName;       <-- from worker record
     * 
     * private String company;        <-- from company record
     * private String address;        <-- from company record
     * private String contact;        <-- from company record
     * 
     * private Date reservationDate;  <-- from reservation record
     * private Boolean status;        <-- from reservation record
     * 
     * private Long userId;           <-- from user record
     * private String userName;       <-- from user record
	 */
	
	@Transactional
	public ReservationViewModel saveReservationViewModel(ReservationViewModel viewModel) throws Exception{

		Reservation reservation = new Reservation();
		
		reservation.setDate(viewModel.getReservationDate());
		reservation.setStatus(viewModel.getStatus());
		reservation.setBookedBy(viewModel.getUserId());
		reservation.setWorkerId(viewModel.getWorkerId());
		if (viewModel.getReservationId() == null) {
			reservation = reservationService.createReservation(reservation);
		} else {
			reservation.setId(viewModel.getReservationId());
			reservationService.updateReservation(reservation);
		}
		
		Worker worker = new Worker();
		worker.setFirstName(viewModel.getFirstName());
		worker.setLastName(viewModel.getLastName());
		worker.setServiceName(viewModel.getService());
		worker.setCompanyId(viewModel.getCompanyId());
		if (viewModel.getWorkerId() == null) {
			workerService.createWorker(worker);
		} else {
			worker.setId(viewModel.getWorkerId());
			workerService.updateWorker(worker);
		}
		
		Company company = new Company();
		company.setName(viewModel.getCompanyName());
		company.setAddress(viewModel.getCompanyAddress());
		company.setPhoneNumber(viewModel.getContact());
		if (viewModel.getCompanyId() == null) {
			companyService.createCompany(company);
		} else {
			company.setId(viewModel.getCompanyId());
			companyService.updateCompany(company);
		}
		
		
		return buildReservationViewModel(reservation);
	}
	

	public ReservationViewModel getReservationViewModel(Long reservationId){
		try {
    		Reservation reservation = reservationService.getReservationById(reservationId);
    		return buildReservationViewModel(reservation);
            
        } catch (NullPointerException e) {
            // if there is no Company with this id, just return null
            return null;
        }
		
	}
	
	public List<ReservationViewModel> getAllReservationViewModel(){
        List<Reservation> reservationList = reservationService.getAllReservations();

        List<ReservationViewModel> rvmList = new ArrayList<>();

        for (Reservation reservation : reservationList) {
            ReservationViewModel rvm = buildReservationViewModel(reservation);
            rvmList.add(rvm);
        }
        return rvmList;

	}
	

	public List<ReservationViewModel> getReservationViewModelByCompany(Long companyId){
        List<Reservation> reservationList = reservationService.getAllReservations();

        List<ReservationViewModel> rvmList = new ArrayList<>();

        ReservationViewModel rvm = new ReservationViewModel();
        
        for (Reservation reservation : reservationList) {
            rvm = buildReservationViewModel(reservation);
            if (rvm.getCompanyId().equals(companyId)) {
            	rvmList.add(rvm);
            } 
        }
        return rvmList;
	}


	public List<ReservationViewModel> getReservationViewModelByUserId(Long userId){
        List<Reservation> reservationList = reservationService.getAllReservations();

        List<ReservationViewModel> rvmList = new ArrayList<>();

        ReservationViewModel rvm = new ReservationViewModel();
        
        for (Reservation reservation : reservationList) {
            rvm = buildReservationViewModel(reservation);
            if ( (rvm.getUserId() != null) && (rvm.getUserId().equals(userId))) {
            	rvmList.add(rvm);
            } 
        }
        return rvmList;
	}

	
	@Transactional
	public ReservationViewModel updateReservationViewModel(ReservationViewModel viewModel) throws Exception{

		Reservation reservation = new Reservation();
		
		reservation.setDate(viewModel.getReservationDate());
		reservation.setStatus(viewModel.getStatus());
		reservation.setBookedBy(viewModel.getUserId());
		reservation.setWorkerId(viewModel.getWorkerId());
		if (viewModel.getReservationId() == null) {
			reservation = reservationService.createReservation(reservation);
		} else {
			reservation.setId(viewModel.getReservationId());
			reservationService.updateReservation(reservation);
		}
		
		return buildReservationViewModel(reservation);
	}

	
	
    /* Helper Methods
     * This method will populate the ServiceRowViewModel based on  
     * combined information from reservation table, worker table, company table,
     * and user table. 
     * 
     * Mapping:
     * private Long reservationId;    <-- from reservation record
     * private String service;        <-- from worker record
     * private Long companyId;        <-- from worker record
     * private String company;        <-- from company record
     * private String address;        <-- from company record
     * private String contact;        <-- from company record
     * private Long workerId;         <-- from worker record
     * private String firstlName;     <-- from worker record
     * private String lastName;       <-- from worker record
     * private Date reservationDate;  <-- from reservation record
     * private Boolean status;        <-- from reservation record
     * private Long userId;           <-- from user record
     * private String userName;       <-- from user record
     * 
     */
    private ReservationViewModel buildReservationViewModel(Reservation reservation) {

        ReservationViewModel srvm = new ReservationViewModel();

        // Get worker details
        Worker worker = workerService.getWorkerById(reservation.getWorkerId());
        
        // Get Company details
        Company company = companyService.getCompanyById(worker.getCompanyId());
        
        User user = new User();
        
        // get User Details
        if (reservation.getBookedBy() != null) {
        	user = userService.getUserById(reservation.getBookedBy());
            srvm.setUserId(user.getId());
            srvm.setUserName(user.getUsername());

        }
        
        srvm.setReservationId(reservation.getId());      

        srvm.setService(worker.getServiceName());
        srvm.setCompanyId(worker.getCompanyId());
        
        srvm.setCompanyName(company.getName());
        srvm.setCompanyAddress(company.getAddress());
        srvm.setContact(company.getPhoneNumber());
        
        srvm.setWorkerId(worker.getId());
        srvm.setFirstName(worker.getFirstName());
        srvm.setLastName(worker.getLastName());
        
        srvm.setReservationDate(reservation.getDate());
        srvm.setStatus(reservation.getStatus());
        
        if (user != null) {
            srvm.setUserId(user.getId());
            srvm.setUserName(user.getUsername());
        }

        return srvm;

    }

	
}
