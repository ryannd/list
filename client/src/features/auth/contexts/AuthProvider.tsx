import { onAuthStateChanged } from 'firebase/auth';
import React, { ReactNode, createContext, useEffect, useState } from 'react';
import { auth } from '../../../lib/firebase/clientApp';
import { User } from '@/types';

export type AuthContextState = { user: User; idToken: string | null };

const AuthContext = createContext<AuthContextState | null>(null);

const AuthProvider = ({ children }: { children: ReactNode }) => {
    const [user, setUser] = useState<User>(null);
    const [idToken, setIdToken] = useState<string | null>(null);

    useEffect(() => {
        const unsubscribe = onAuthStateChanged(auth, async (user) => {
            setUser(user);
            if (user) {
                const idToken = await user.getIdToken();
                setIdToken(idToken);
            } else {
                setIdToken(null);
            }
        });
        return unsubscribe;
    }, []);

    // refresh every 10 mins
    useEffect(() => {
        const handle = setInterval(
            async () => {
                if (user) {
                    const idToken = await user.getIdToken();
                    setIdToken(idToken);
                }
            },
            10 * 60 * 1000,
        );

        return () => clearInterval(handle);
    }, [user]);

    return (
        <AuthContext.Provider value={{ user, idToken }}>
            {children}
        </AuthContext.Provider>
    );
};

export { AuthProvider, AuthContext };
