import { onAuthStateChanged, User as UserType } from 'firebase/auth';
import React, { ReactNode, createContext, useEffect, useState } from 'react';
import { auth } from '../../../lib/firebase/clientApp';

type User = UserType | null;
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

    return (
        <AuthContext.Provider value={value}>{children}</AuthContext.Provider>
    );
};

export { AuthProvider, AuthContext };
