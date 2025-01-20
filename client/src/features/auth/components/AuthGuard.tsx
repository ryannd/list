'use client';

import useFirebaseAuth from '@/features/auth/hooks/useAuth';
import { getAuth, onAuthStateChanged } from 'firebase/auth';
import { useRouter } from 'next/navigation';
import { useState, useEffect, ReactNode } from 'react';

export default function AuthGuard({ children }: { children: ReactNode }) {
    const router = useRouter();
    const user = useFirebaseAuth();
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    useEffect(() => {
        const auth = getAuth();
        const unsubscribe = onAuthStateChanged(auth, (user) => {
            if (user) {
                setIsLoggedIn(true);
            } else {
                setIsLoggedIn(false);
                router.push('/auth');
            }
        });

        return unsubscribe;
    }, [user, router]);

    if (isLoggedIn) {
        return children;
    } else {
        return null;
    }
}
