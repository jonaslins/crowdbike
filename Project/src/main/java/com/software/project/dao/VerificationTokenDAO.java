package com.software.project.dao;

import com.software.project.entities.VerificationToken;

public interface VerificationTokenDAO extends GenericDAO<VerificationToken, Long> {
	VerificationToken getByToken(String token);
}
