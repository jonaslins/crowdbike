package com.software.project.dao;

import com.software.project.entities.PasswordResetToken;

public interface PasswordResetTokenDAO extends GenericDAO<PasswordResetToken, Long> {
	public PasswordResetToken getByToken(String token);
}
