'use client';

import { ReactNode } from 'react';
import { AuthProvider } from '../features/auth/contexts/AuthProvider';

type ProviderProps = {
    children: ReactNode;
};

export default function Providers({ children }: ProviderProps) {
    return <AuthProvider>{children}</AuthProvider>;
}
