'use client';

import { ReactNode } from 'react';
import { AuthProvider } from '../features/auth/contexts/AuthProvider';
import { ThemeProvider } from '../components/ThemeProvider';

type ProviderProps = {
    children: ReactNode;
};

export default function Providers({ children }: ProviderProps) {
    return (
        <AuthProvider>
            {' '}
            <ThemeProvider
                attribute="class"
                defaultTheme="dark"
                enableSystem
                disableTransitionOnChange
            >
                {children}
            </ThemeProvider>
        </AuthProvider>
    );
}
