import { onAuthStateChanged } from 'firebase/auth';
import React, { ReactNode, createContext, useEffect, useState } from 'react';
import { auth } from '../../../lib/firebase/clientApp';
import { User } from '@/types';

export type AuthContextState = { user: User };

const AuthContext = createContext<AuthContextState | null>(null);

const AuthProvider = ({ children }: { children: ReactNode }) => {
    const [user, setUser] = useState<User>(null);

    useEffect(() => {
        const unsubscribe = onAuthStateChanged(auth, (user) => {
            setUser(user);
        });
        return unsubscribe;
    }, []);

    // refresh every 10 mins
    useEffect(() => {
        const handle = setInterval(
            async () => {
                if (user) await user.getIdToken(true);
            },
            10 * 60 * 1000,
        );

        return () => clearInterval(handle);
    }, [user]);

    return (
        <AuthContext.Provider value={{ user }}>{children}</AuthContext.Provider>
    );
};

export { AuthProvider, AuthContext };
