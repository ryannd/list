'use client';

import useFirebaseAuth from '@/features/auth/hooks/useAuth';
import AuthForm from '@/features/auth/components/AuthForm';
import { useEffect } from 'react';
import { useRouter } from 'next/navigation';

export default function Auth() {
    const user = useFirebaseAuth();
    const router = useRouter();

    useEffect(() => {
        // go home if authenticated
        user?.getIdToken().then(() => {
            router.push('/');
        });
    }, [user, router]);

    return (
        <div className="flex h-full w-full flex-col items-center justify-center">
            <AuthForm />
        </div>
    );
}
