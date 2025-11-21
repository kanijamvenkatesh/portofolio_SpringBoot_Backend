package com.venky.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.venky.entity.ContactMessage;

public interface ContactRepository extends JpaRepository<ContactMessage, Long> {

	@SuppressWarnings("unchecked")
	ContactMessage save(ContactMessage msg);
}
