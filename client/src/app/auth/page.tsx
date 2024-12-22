'use client';

import { signInWithGoogle } from '../../lib/firebase/auth';
import useFirebaseAuth from '../../features/auth/hooks/useAuth';
import { useEffect, useState } from 'react';

export default function Auth() {
    const user = useFirebaseAuth();
    const [id, setId] = useState('');

    useEffect(() => {
        user?.getIdToken().then((str) => {
            setId(str);
        });
    }, [user]);

    const handleSignIn = async () => {
        await signInWithGoogle();
    };

    return (
        <>
            <button onClick={handleSignIn}>Sign in with Google</button>
            <h1>{user?.email}</h1>
            <h1>{id}</h1>
        </>
    );
}
