'use client'

import { useContext, useEffect } from "react";
import { signInWithGoogle } from "../../lib/firebase/auth";
import { AuthContext, AuthProvider } from "../../features/auth/contexts/AuthProvider";
import useFirebaseAuth from "../../features/auth/hooks/useAuth";

export default function Auth() {
    const user = useFirebaseAuth();

    const handleSignIn = async () => {
        await signInWithGoogle();
    }   

    return <>
        <button onClick={handleSignIn}>
            Sign in with Google
        </button>
        <h1>{user?.email}</h1>
    </>

}