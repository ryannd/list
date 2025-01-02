import { onAuthStateChanged } from 'firebase/auth';
import React, { ReactNode, createContext, useEffect, useState } from 'react';
import { auth } from '../../../lib/firebase/clientApp';
import { User } from '@/types';

type ContextState = { user: User };

const AuthContext = createContext<ContextState | undefined>(undefined);

const AuthProvider = ({ children }: { children: ReactNode }) => {
    const [user, setUser] = useState<User>(null);
    const value = { user };

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
        <AuthContext.Provider value={value}>{children}</AuthContext.Provider>
    );
};

export { AuthProvider, AuthContext };
