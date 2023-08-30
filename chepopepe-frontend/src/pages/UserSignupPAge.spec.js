import React from "react";
import { render, screen } from "@testing-library/react";
import '@testing-library/jest-dom/extend-expect';
import UserSignupPage from "./UserSignupPage";

describe('UserSignupPage', () => {
    it('has header of Sign up', () => {
        render(<UserSignupPage />);
        const header = screen.getByRole('heading', { name: 'Sign up' });
        expect(header).toBeInTheDocument();
    });

    it('has input for display name', () => {
        render(<UserSignupPage />);
        const displayNameInput = screen.getByPlaceholderText('Your display name');
        expect(displayNameInput).toBeInTheDocument();
    });

    it('has input for username', () => {
        render(<UserSignupPage />);
        const displayNameInput = screen.getByPlaceholderText('Your username');
        expect(displayNameInput).toBeInTheDocument();
    });

    it('has input for password', () => {
        render(<UserSignupPage />);
        const displayNameInput = screen.getByPlaceholderText('Your password');
        expect(displayNameInput).toBeInTheDocument();
    });

    it('has password type for password input', () => {
        render(<UserSignupPage />);
        const passwordInput = screen.getByPlaceholderText('Your password');
        expect(passwordInput.type).toBe('password');
    });

    it('has input for password repeat', () => {
        render(<UserSignupPage />);
        const passwordRepeat = screen.getByPlaceholderText('Repeat your password');
        expect(passwordRepeat).toBeInTheDocument();
    });

    it('has password type for repeat password input', () => {
        render(<UserSignupPage />);
        const passwordInput = screen.getByPlaceholderText('Repeat your password');
        expect(passwordInput.type).toBe('password');
    });

    it('has sumbit button', () => {
        render(<UserSignupPage />);
        const button = screen.getByRole('button', {name : 'Sign up'})
        expect(button).toBeInTheDocument();
    })
});